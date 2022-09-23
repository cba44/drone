package com.chiran.drone.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "drone")
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @Column(unique = true)
	private String serial;
	@Enumerated(EnumType.STRING)
	private DroneModel model;
	private float weightLimit;
	private byte batteryCapacity;
	@Enumerated(EnumType.STRING)
	private LoadState state;

    @OneToMany(mappedBy = "drone", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Medication> medications = new ArrayList<>();

    public Drone() {
    	super();
    }

	public Drone(@Size(max = 100) String serial, DroneModel model, float weightLimit, byte batteryCapacity,
			LoadState state) {
		this.serial = serial;
		this.model = model;
		this.weightLimit = weightLimit;
		this.batteryCapacity = batteryCapacity;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public DroneModel getModel() {
		return model;
	}

	public void setModel(DroneModel model) {
		this.model = model;
	}

	public float getWeightLimit() {
		return weightLimit;
	}

	public void setWeightLimit(float weightLimit) {
		this.weightLimit = weightLimit;
	}

	public byte getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(byte batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public LoadState getState() {
		return state;
	}

	public void setState(LoadState state) {
		this.state = state;
	}

	public List<Medication> getMedications() {
		return medications;
	}

	public void setMedications(List<Medication> medications) {
		this.medications = medications;
	}

}