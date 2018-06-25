package com.restful.exceptions;

public class ThrowExceptionMessage extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ThrowExceptionMessage(String message) {
		super(message);
	}
}
