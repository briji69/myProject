package com.capgemini.busschedulingjdbc.exceptions;

public class BusNotFoundException extends RuntimeException{

	private String message="BusNotFoundException";

	public BusNotFoundException() {
		super();
				}

	public String getMessage() {
		return message;
	}
	
}
