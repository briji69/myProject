package com.capgemini.busschedulingjdbc.exceptions;

public class DeletionFailedException extends Exception {
	
	private String message="DeletionFailedException";
	public DeletionFailedException() {
		super();
				}

	public String DeletionFailedException() {
		return message;
	}
}
