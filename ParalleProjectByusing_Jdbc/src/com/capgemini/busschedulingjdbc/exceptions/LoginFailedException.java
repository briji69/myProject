package com.capgemini.busschedulingjdbc.exceptions;

public class LoginFailedException extends Exception {

	private String message="LoginFailedException";
	public LoginFailedException() {
		super();
				}

	public String LoginFailedException() {
		return message;
	}
}
