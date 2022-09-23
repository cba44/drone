package com.chiran.drone.service;

import java.util.List;

import com.chiran.drone.entities.Drone;
import com.chiran.drone.entities.Medication;

public interface DroneService {

	Drone registerDrone(Drone drone);
	List<Medication> getMedicationForDrone(String serial);
	List<Medication> loadMedicineToDrone(String serial, List<Medication> medications);
	Byte getBatteryLevel(String serial);

}
