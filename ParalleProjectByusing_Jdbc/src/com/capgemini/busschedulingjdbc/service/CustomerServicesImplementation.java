package com.capgemini.busschedulingjdbc.service;

import com.capgemini.busschedulingjdbc.beans.Feedback;
import com.capgemini.busschedulingjdbc.beans.Ticket;
import com.capgemini.busschedulingjdbc.dao.CustomerDAO;
import com.capgemini.busschedulingjdbc.dao.CustomerDAOImplementation;

public class CustomerServicesImplementation implements CustomerServices{

	CustomerDAO customerDAO = new CustomerDAOImplementation();

	@Override
	public Ticket bookTicket(int busId, int userId,  int noOfSeats) {
		return customerDAO.bookTicket(busId, userId, noOfSeats);
	}

	@Override
	public boolean cancelTicket(int ticketId, int userId, int noOfSeats) {
		return customerDAO.cancelTicket(ticketId, userId, noOfSeats);
	}

	@Override
	public Ticket getTicketInfo(int ticketId) {
		return customerDAO.getTicketInfo(ticketId);
	}

	@Override
	public boolean giveFeedback(Feedback feedback) {
		return customerDAO.giveFeedback(feedback);
	}

}
