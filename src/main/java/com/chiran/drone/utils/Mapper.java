package com.chiran.drone.utils;

import org.springframework.stereotype.Component;

import com.chiran.drone.dto.DroneDTO;
import com.chiran.drone.dto.MedicationDTO;
import com.chiran.drone.entities.Drone;
import com.chiran.drone.entities.DroneModel;
import com.chiran.drone.entities.LoadState;
import com.chiran.drone.entities.Medication;
import com.chiran.drone.exception.WrongEnumException;

@Component
public class Mapper {

	public DroneDTO toDroneDTO(Drone drone) {
		return new DroneDTO(drone.getSerial(), drone.getModel().toString(), drone.getWeightLimit(),
				drone.getBatteryCapacity(), drone.getState().toString());
	}

	public Drone toDrone(DroneDTO droneDTO) {
		Drone drone = null;
		try {
		drone = new Drone(droneDTO.getSerial(), DroneModel.valueOf(droneDTO.getModel().toUpperCase()), droneDTO.getWeightLimit(),
				droneDTO.getBatteryCapacity(), LoadState.valueOf(droneDTO.getState().toUpperCase()));
		} catch(IllegalArgumentException e) {
			throw new WrongEnumException("Wrong model or state value");
		}
		return drone;
	}

	public MedicationDTO toMedicationDTO(Medication medication) {
		return new MedicationDTO(medication.getName(), medication.getWeight(), medication.getCode(),
				medication.getImage());
	}

	public Medication toMedication(MedicationDTO medicationDTO) {
		return new Medication(medicationDTO.getName(), medicationDTO.getWeight(), medicationDTO.getCode(),
				medicationDTO.getImage());
	}

}
