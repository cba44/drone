package com.chiran.drone.exception;

public class DroneAlreadyExistsException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = -1944619098650416618L;

	public DroneAlreadyExistsException(String message) {
		super(message);
	}

}
