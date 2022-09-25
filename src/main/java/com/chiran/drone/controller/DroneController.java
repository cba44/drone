package com.chiran.drone.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chiran.drone.dto.AvailableDroneDTO;
import com.chiran.drone.dto.DroneDTO;
import com.chiran.drone.dto.DroneMedicationDTO;
import com.chiran.drone.entities.Drone;
import com.chiran.drone.entities.Medication;
import com.chiran.drone.service.DroneService;
import com.chiran.drone.utils.Mapper;

@RestController
@RequestMapping("/api/v1")
public class DroneController {

	private final DroneService droneService;
	private final Mapper mapper;

	public DroneController(DroneService droneService, Mapper mapper) {
		this.droneService = droneService;
		this.mapper = mapper;
	}

	@PostMapping("/drones")
	public ResponseEntity<DroneDTO> registerDrone(@Valid @RequestBody DroneDTO droneDTO) {
		Drone drone = droneService.registerDrone(mapper.toDrone(droneDTO));
		return new ResponseEntity<DroneDTO>(mapper.toDroneDTO(drone), HttpStatus.CREATED);
	}

	@PostMapping("/drones/medications")
	public ResponseEntity<DroneMedicationDTO> loadMedicineToDrone(@Valid @RequestBody DroneMedicationDTO droneMedicationDTO) {
		String serial = droneMedicationDTO.getSerial();
		List<Medication> medications = droneMedicationDTO.getMedications().stream().map(med -> mapper.toMedication(med)).collect(Collectors.toList());
		medications = droneService.loadMedicineToDrone(serial, medications);
		droneMedicationDTO.getMedications().clear();
		droneMedicationDTO.setMedications(medications.stream().map(med -> mapper.toMedicationDTO(med)).collect(Collectors.toList()));
		return new ResponseEntity<DroneMedicationDTO>(droneMedicationDTO, HttpStatus.CREATED);
	}

	@GetMapping("/drones/medications/{serial}")
	public ResponseEntity<DroneMedicationDTO> loadedMedicationsForDrone(@PathVariable String serial) {
		List<Medication> medicationForDrone = droneService.getMedicationForDrone(serial);
		DroneMedicationDTO droneMedicationDTO = new DroneMedicationDTO(serial, medicationForDrone.stream()
				.map(med -> mapper.toMedicationDTO(med)).collect(Collectors.toList()));
		return ResponseEntity.ok(droneMedicationDTO);
	}

	@GetMapping("/drones/available")
	public ResponseEntity<AvailableDroneDTO> getAvailableDrones() {
		List<Drone> availableDrones = droneService.getAvailableDrones();
		AvailableDroneDTO availableDroneDTO = new AvailableDroneDTO();
		availableDroneDTO.setDrones(availableDrones.stream().map(drn -> mapper.toDroneDTO(drn)).collect(Collectors.toList()));
		return ResponseEntity.ok(availableDroneDTO);
	}

	@GetMapping("/drones/battery/{serial}")
	public ResponseEntity<Integer> getBatteryLevel(@PathVariable String serial) {
		return ResponseEntity.ok(droneService.getBatteryLevel(serial));
	}

}
