package com.zaid.example.Customer.Exceptions;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	// Handle ResourceNotFoundException
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
		return new ResponseEntity<>(Map.of("error", ex.getMessage()), HttpStatus.BAD_REQUEST);
	}

	// Handle IllegalArgumentException
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
		return new ResponseEntity<>(Map.of("error", ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
	// Handle No Such Value Exception
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Map<String, String>> handleNoSuchElementException(NoSuchElementException ex) {
//		return new ResponseEntity<>(Map.of("error", ex.getMessage()), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(Map.of("error", "No such value found in DB "), HttpStatus.BAD_REQUEST);
	}

	// Handle Generic Exception
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<Map<String, String>> handleGlobalException(Exception ex) {
//		return new ResponseEntity<>(Map.of("error", "An unexpected error occurred: " + ex.getMessage()),
//				HttpStatus.INTERNAL_SERVER_ERROR);
//	}
}
