package com.capgemini.busschedulingjdbc.exceptions;

public class UserNotFoundException extends Exception {

	private String message="UserNotFoundException";
	public UserNotFoundException() {
		super();
				}

	public String UserNotFoundException() {
		return message;
	}
	
	
}
