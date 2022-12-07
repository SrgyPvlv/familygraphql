package com.example.familygraphql.exeption;

public class FamilyNotFoundExeption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FamilyNotFoundExeption(String message) {
		super(message);
	}
	
	public FamilyNotFoundExeption(String message, Throwable cause) {
		super(message,cause);
	}
	
}
