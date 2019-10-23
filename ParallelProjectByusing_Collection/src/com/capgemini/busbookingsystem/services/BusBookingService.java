package com.capgemini.busbookingsystem.services;

import java.util.List;

import com.capgemini.busbookingsystem.beans.Booking;
import com.capgemini.busbookingsystem.beans.Bus;

public interface BusBookingService {
	public Bus getBus(int bus_id);
	public List<Integer> showAllBusInfo();
	
	//ticket booking
	public Boolean bookTicket(Booking ticket);
	public List<Booking> showUserBookedTicket(int userID);

	public Boolean cancelTicket(int ticket_id);
}
