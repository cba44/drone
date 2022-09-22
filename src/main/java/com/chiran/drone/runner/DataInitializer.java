package com.chiran.drone.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.chiran.drone.entities.Drone;
import com.chiran.drone.entities.DroneModel;
import com.chiran.drone.entities.LoadState;
import com.chiran.drone.entities.Medicine;
import com.chiran.drone.repository.DroneRepository;
import com.chiran.drone.repository.MedicineRepository;

@Component
public class DataInitializer implements CommandLineRunner {

	private final DroneRepository droneRepository;
	private final MedicineRepository medicineRepository;

	public DataInitializer(DroneRepository droneRepository, MedicineRepository medicineRepository) {
		this.droneRepository = droneRepository;
		this.medicineRepository = medicineRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Drone drone1 = new Drone("serial1", DroneModel.Cruiserweight, 300.0f, (byte)45, LoadState.IDLE);
		droneRepository.save(drone1);
		Drone drone2 = new Drone("serial1", DroneModel.Cruiserweight, 300.0f, (byte)45, LoadState.IDLE);
		droneRepository.save(drone2);

		Medicine med1 = new Medicine("medicine1", 200, "Code123", "url1", drone1);
		medicineRepository.save(med1);
		Medicine med2 = new Medicine("medicine2", 200, "Code123", "url2", drone1);
		medicineRepository.save(med2);
		Medicine med3 = new Medicine("medicine3", 200, "Code123", "url3", drone2);
		medicineRepository.save(med3);
		Medicine med4 = new Medicine("medicine4", 200, "Code123", "url4", drone2);
		medicineRepository.save(med4);

	}

}
