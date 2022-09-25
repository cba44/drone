package com.chiran.drone.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = DroneAlreadyExistsException.class)
	public ResponseEntity<ExceptionResponse> handleBatteriesNotFound(DroneAlreadyExistsException e) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = DroneNotExistsException.class)
	public ResponseEntity<ExceptionResponse> handleIllegalInput(DroneNotExistsException e) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> handleMethodArgumentsNotValid() {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Invalid Arguments");
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = WrongEnumException.class)
	public ResponseEntity<ExceptionResponse> handleEnumNotValid(WrongEnumException e) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
