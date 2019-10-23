package com.capgemini.busschedulingjdbc.beans;

import java.sql.Timestamp;
import java.util.Date;

public class Ticket {
	private int ticketId;
	private int busId;
	private int userId;
	private Date journeyDate;
	private int noOfSeats;
	private Timestamp reservationDateTime;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	public Timestamp getReservationDateTime() {
		return reservationDateTime;
	}
	public void setReservationDateTime(Timestamp reservationDateTime) {
		this.reservationDateTime = reservationDateTime;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", busId=" + busId + ", userId=" + userId + ", journeyDate="
				+ journeyDate + ", noOfSeats=" + noOfSeats + ", reservationDateTime=" + reservationDateTime + "]";
	}

}
