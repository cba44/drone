package com.chiran.drone.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.chiran.drone.entities.Drone;
import com.chiran.drone.entities.DroneModel;
import com.chiran.drone.entities.LoadState;
import com.chiran.drone.entities.Medication;
import com.chiran.drone.repository.DroneRepository;
import com.chiran.drone.repository.MedicationRepository;

@Component
public class DataInitializer implements CommandLineRunner {

	private final DroneRepository droneRepository;
	private final MedicationRepository medicationRepository;

	public DataInitializer(DroneRepository droneRepository, MedicationRepository medicationRepository) {
		this.droneRepository = droneRepository;
		this.medicationRepository = medicationRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Drone drone1 = new Drone("serial1", DroneModel.CRUISERWEIGHT, 500.0f, 45, LoadState.IDLE);
		droneRepository.save(drone1);
		Drone drone2 = new Drone("serial2", DroneModel.CRUISERWEIGHT, 500.0f, 45, LoadState.IDLE);
		droneRepository.save(drone2);

		Medication med1 = new Medication("medicine1", 50, "MEDA", "url1", drone1);
		medicationRepository.save(med1);
		Medication med2 = new Medication("medicine2", 10, "MEDB", "url2", drone1);
		medicationRepository.save(med2);
		Medication med3 = new Medication("medicine3", 60, "MEDC", "url3", drone2);
		medicationRepository.save(med3);
		Medication med4 = new Medication("medicine4", 70, "MEDD", "url4", drone2);
		medicationRepository.save(med4);

	}

}
