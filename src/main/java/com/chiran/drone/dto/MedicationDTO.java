package com.chiran.drone.dto;

import javax.validation.constraints.Pattern;

public class MedicationDTO {

	@Pattern(regexp = "[A-Za-z0-9-_]+")
	private String name;
	private double weight;
	@Pattern(regexp = "[A-Z-_]+")
	private String code;
	private String image;

	public MedicationDTO() {
		super();
	}

	public MedicationDTO(@Pattern(regexp = "[A-Za-z0-9-_]+") String name, double weight,
			@Pattern(regexp = "[A-Z-_]+") String code, String image) {
		this.name = name;
		this.weight = weight;
		this.code = code;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
