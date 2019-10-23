package com.capgemini.busbookingsystem.dao;

import java.util.List;

import com.capgemini.busbookingsystem.beans.Booking;
import com.capgemini.busbookingsystem.beans.Bus;
import com.capgemini.busbookingsystem.exceptions.BookTicketException;
import com.capgemini.busbookingsystem.exceptions.CancelTicketException;
import com.capgemini.busbookingsystem.exceptions.CreateBusException;
import com.capgemini.busbookingsystem.exceptions.GetBusException;
import com.capgemini.busbookingsystem.exceptions.ShowUserBookedTicketException;

public interface BusBookingDAO {
	public Bus getBus(int bus_id) throws GetBusException;
	public List<Integer> showAllBusInfo() throws CreateBusException;



	//ticket booking
	public Boolean bookTicket(Booking ticket) throws BookTicketException;
	public Boolean cancelTicket(int ticket_id) throws CancelTicketException;
	public List<Booking> showUserBookedTicket(int userID) throws ShowUserBookedTicketException;
}
