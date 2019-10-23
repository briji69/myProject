package com.capgemini.busschedulingspringmvc.service;


import com.capgemini.busschedulingspringmvc.beans.Feedback;
import com.capgemini.busschedulingspringmvc.beans.Ticket;
import com.capgemini.busschedulingspringmvc.beans.User;


public interface CustomerService {

	public Boolean updateCustomer(User user) ;
	public Boolean deleteCustomer(Integer customerId) ;
	public Ticket bookTicket(Ticket ticket) ;
	public Boolean cancelTicket(Integer bookingId, Integer customerId);
	public Ticket getTicketInfo(Integer bookingId);
	public Boolean writeFeedback(Feedback feed);
}
