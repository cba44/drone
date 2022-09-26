package com.chiran.drone.dto;

import java.util.List;

import javax.validation.Valid;

public class DroneMedicationDTO {

	private String serial;
	@Valid
	private List<MedicationDTO> medications;

	public DroneMedicationDTO() {
		super();
	}

	public DroneMedicationDTO(String serial, @Valid List<MedicationDTO> medications) {
		super();
		this.serial = serial;
		this.medications = medications;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public List<MedicationDTO> getMedications() {
		return medications;
	}

	public void setMedications(List<MedicationDTO> medications) {
		this.medications = medications;
	}

}
