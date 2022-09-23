package com.chiran.drone.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chiran.drone.entities.Drone;
import com.chiran.drone.entities.Medication;
import com.chiran.drone.service.DroneService;

@RestController
@RequestMapping("/api/v1")
public class DroneController {

	private final DroneService droneService;

	public DroneController(DroneService droneService) {
		this.droneService = droneService;
	}

	@PostMapping("/drones")
	public ResponseEntity<Drone> registerDrone(@RequestBody Drone drone) {
		return new ResponseEntity<Drone>(droneService.registerDrone(drone), HttpStatus.CREATED);
	}

	@PostMapping("/drones/medications/{serial}")
	public ResponseEntity<List<Medication>> loadMedicineToDrone(@PathVariable String serial, @RequestBody List<Medication> medications) {
		return new ResponseEntity<List<Medication>>(droneService.loadMedicineToDrone(serial, medications), HttpStatus.CREATED);
	}

	@GetMapping("/drones/medications/{serial}")
	public List<Medication> loadedMedicationsForDrone(@PathVariable String serial) {
		return droneService.getMedicationForDrone(serial);
	}

	@GetMapping("/drones/available")
	public List<Drone> getAvailableDrones() {
		//TODO implement this
		return null;
	}

	@GetMapping("/drones/battery/{serial}")
	public ResponseEntity<Byte> getBatteryLevel(@PathVariable String serial) {
		return ResponseEntity.ok(droneService.getBatteryLevel(serial));
	}

}
