package com.capgemini.busschedulingjdbc.exceptions;

public class ReservationFailedException extends Exception{

	private String message="ReservationFailedException";
	public ReservationFailedException() {
		super();
				}

	public String ReservationFailedException() {
		return message;
	}
}
