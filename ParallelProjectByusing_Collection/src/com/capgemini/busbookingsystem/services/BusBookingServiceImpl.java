package com.capgemini.busbookingsystem.services;

import java.util.List;

import com.capgemini.busbookingsystem.beans.Booking;
import com.capgemini.busbookingsystem.beans.Bus;
import com.capgemini.busbookingsystem.dao.BusBookingDAO;
import com.capgemini.busbookingsystem.dao.BusBookingDAOImplementation;

public class BusBookingServiceImpl implements BusBookingService {
	BusBookingDAO dao = new BusBookingDAOImplementation();
	
	@Override
	public Bus getBus(int bus_id) {
		return dao.getBus(bus_id);
	}
	
	@Override
	public List<Integer> showAllBusInfo() {
		return dao.showAllBusInfo();
	}	


	@Override
	public Boolean bookTicket(Booking ticket) {
		return dao.bookTicket(ticket);
	}

	@Override
	public Boolean cancelTicket(int ticket_id) {
		return dao.cancelTicket(ticket_id);
		}

	@Override
	public List<Booking> showUserBookedTicket(int userID) {
		return dao.showUserBookedTicket(userID);
	}
}
