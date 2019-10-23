package com.capgemini.busbookingsystem.beans;


public class Booking{

	private int ticket_id;
	private int bus_id;
	private int user_id;
	private int numofseats;
	
	
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public int getBus_id() {
		return bus_id;
	}
	public void setBus_id(int bus_id) {
		this.bus_id = bus_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getNumofseats() {
		return numofseats;
	}
	public void setNumofseats(int numofseats) {
		this.numofseats = numofseats;
	}
	
	
	@Override
	public String toString() {
		return "Ticket [ticket_id=" + ticket_id + ", bus_id=" + bus_id + ", user_id=" + user_id + ", numofseats="
				+ numofseats + "]";
	}	
}
