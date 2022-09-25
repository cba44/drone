package com.chiran.drone.dto;

import java.util.List;

public class AvailableDroneDTO {

	private List<DroneDTO> drones;

	public AvailableDroneDTO() {
		super();
	}

	public AvailableDroneDTO(List<DroneDTO> drones) {
		this.drones = drones;
	}

	public List<DroneDTO> getDrones() {
		return drones;
	}

	public void setDrones(List<DroneDTO> drones) {
		this.drones = drones;
	}


}
