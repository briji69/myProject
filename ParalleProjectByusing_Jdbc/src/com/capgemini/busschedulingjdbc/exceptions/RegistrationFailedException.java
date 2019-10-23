package com.capgemini.busschedulingjdbc.exceptions;

public class RegistrationFailedException extends Exception{

	private String message="RegistrationFailedException";
	public RegistrationFailedException() {
		super();
				}

	public String RegistrationFailedException() {
		return message;
	}
}
