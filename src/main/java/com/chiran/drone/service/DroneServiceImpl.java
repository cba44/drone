package com.chiran.drone.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.chiran.drone.entities.Drone;
import com.chiran.drone.entities.LoadState;
import com.chiran.drone.entities.Medication;
import com.chiran.drone.exception.DroneAlreadyExistsException;
import com.chiran.drone.exception.DroneNotExistsException;
import com.chiran.drone.repository.DroneRepository;
import com.chiran.drone.repository.MedicationRepository;

@Service
public class DroneServiceImpl implements DroneService {

	private final DroneRepository droneRepository;
	private final MedicationRepository medicationRepository;

	public DroneServiceImpl(DroneRepository droneRepository, MedicationRepository medicationRepository) {
		this.droneRepository = droneRepository;
		this.medicationRepository = medicationRepository;
	}

	@Override
	public Drone registerDrone(Drone drone) {
		Drone droneInDB = droneRepository.findBySerial(drone.getSerial());
		if (droneInDB != null) {
			throw new DroneAlreadyExistsException("Drone Already Exists for given serial number");
		}
		return droneRepository.save(drone);
	}

	@Override
	public List<Medication> getMedicationForDrone(String serial) {
		Drone drone = droneRepository.findBySerial(serial);
		if (drone == null) {
			throw new DroneNotExistsException("Drone doesn't exist");
		}
		return drone.getMedications();
	}

	@Override
	@Transactional
	public List<Medication> loadMedicineToDrone(String serial, List<Medication> medications) {
		Drone drone = droneRepository.findBySerial(serial);
		if (drone == null) {
			throw new DroneNotExistsException("Drone doesn't exist");
		}
		double totalWeight = drone.getMedications().stream().map(med -> med.getWeight()).mapToDouble(Double::doubleValue).sum();
		List<Medication> savedMedications = new ArrayList<>();
		for (Medication medication : medications) {	//Only saves if the medication can be added to the drone
			if (totalWeight + medication.getWeight() <= drone.getWeightLimit()) {
				totalWeight = totalWeight + medication.getWeight();
				medication.setDrone(drone);
				Medication savedMedication = medicationRepository.save(medication);
				savedMedications.add(savedMedication);
			}
		}
		return savedMedications;
	}

	@Override
	public Integer getBatteryLevel(String serial) {
		Drone drone = droneRepository.findBySerial(serial);
		if (drone == null) {
			throw new DroneNotExistsException("Drone doesn't exist");
		}
		return drone.getBatteryCapacity();
	}

	@Override
	public List<Drone> getAvailableDrones() {
		//Querying all drones since we have only 10 drones
		Iterable<Drone> drones = droneRepository.findAll();
		List<Drone> availableDrones = new ArrayList<>();
		drones.forEach(drone -> {
				if ((LoadState.IDLE.equals(drone.getState()) || LoadState.LOADING.equals(drone.getState())) && drone.getBatteryCapacity() > 25) {
					availableDrones.add(drone);
				}
		});
		return availableDrones;
	}



}
