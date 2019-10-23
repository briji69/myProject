package com.capgemini.busschedulingjdbc.dao;

import com.capgemini.busschedulingjdbc.beans.Feedback;
import com.capgemini.busschedulingjdbc.beans.Ticket;

public interface CustomerDAO {

	public Ticket bookTicket(int busId,int userId, int noOfSeats);
	public boolean cancelTicket(int ticketId, int userId, int noOfSeats);
	public Ticket getTicketInfo(int ticketId);
	public boolean giveFeedback(Feedback feedback);
}
