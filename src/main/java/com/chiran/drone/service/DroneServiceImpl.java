package com.chiran.drone.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.chiran.drone.entities.Drone;
import com.chiran.drone.entities.Medication;
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
		drone.setId(null);
		return droneRepository.save(drone);
	}

	@Override
	public List<Medication> getMedicationForDrone(String serial) {
		Drone drone = droneRepository.findBySerial(serial);
		return drone.getMedications();
	}

	@Override
	@Transactional
	public List<Medication> loadMedicineToDrone(String serial, List<Medication> medications) {
		Drone drone = droneRepository.findBySerial(serial);
		List<Medication> savedMedications = medications.stream().map(med -> {
			med.setId(null);
			med.setDrone(drone);
			return medicationRepository.save(med);
		}).collect(Collectors.toList());
		return savedMedications;
	}

	@Override
	public Byte getBatteryLevel(String serial) {
		Drone drone = droneRepository.findBySerial(serial);
		return drone.getBatteryCapacity();
	}

}
