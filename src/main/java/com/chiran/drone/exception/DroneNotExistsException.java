package com.chiran.drone.exception;

public class DroneNotExistsException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1854204783324966654L;

	public DroneNotExistsException(String message) {
		super(message);
	}

}
