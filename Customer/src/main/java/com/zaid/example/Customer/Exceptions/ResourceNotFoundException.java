package com.zaid.example.Customer.Exceptions;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String str) {
		super(str);
	}
}
