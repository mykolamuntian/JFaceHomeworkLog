package com.muntian.exceptions;

public class NameInputException extends IllegalArgumentException {

	public NameInputException() {
		
	}

	public NameInputException(String message) {
		super(message);
	}
}
