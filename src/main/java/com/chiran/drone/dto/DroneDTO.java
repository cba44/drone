package com.chiran.drone.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DroneDTO {

	@Size(max = 100)
	@NotNull
	private String serial;
	private String model;
	@Min(0)
	@Max(500)
	private double weightLimit;
	@Min(0)
	@Max(100)
	private int batteryCapacity;
	private String state;

	public DroneDTO() {
		super();
	}

	public DroneDTO(@Size(max = 100) @NotNull String serial, String model, @Min(0) @Max(500) double weightLimit,
			@Min(0) @Max(100) int batteryCapacity, String state) {
		this.serial = serial;
		this.model = model;
		this.weightLimit = weightLimit;
		this.batteryCapacity = batteryCapacity;
		this.state = state;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getWeightLimit() {
		return weightLimit;
	}

	public void setWeightLimit(double weightLimit) {
		this.weightLimit = weightLimit;
	}

	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
