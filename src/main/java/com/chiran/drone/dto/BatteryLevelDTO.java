package com.chiran.drone.dto;

public class BatteryLevelDTO {

	private String drone;
	private int batteryLevel;

	public BatteryLevelDTO() {
		super();
	}

	public BatteryLevelDTO(String drone, int batteryLevel) {
		this.drone = drone;
		this.batteryLevel = batteryLevel;
	}

	public String getDrone() {
		return drone;
	}

	public void setDrone(String drone) {
		this.drone = drone;
	}

	public int getBatteryLevel() {
		return batteryLevel;
	}

	public void setBatteryLevel(int batteryLevel) {
		this.batteryLevel = batteryLevel;
	}

}
