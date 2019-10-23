package com.capgemini.busscheduling.dao;


import com.capgemini.busscheduling.dto.Feedback;
import com.capgemini.busscheduling.dto.Ticket;
import com.capgemini.busscheduling.dto.User;

public interface CustomerDAO {

	//user operations	
	public User registerCustomer( User customer) ;
	public User loginCustomer(Integer customerId, String password)  ;
	public Boolean updateCustomer(User customer) ;
	public Boolean deleteCustomer(Integer customerId) ;
	public Ticket bookTicket(Ticket ticket) ;
	public Boolean cancelTicket(Integer bookingId, Integer customerId);
	public Ticket getTicketInfo(Ticket bookingId);
	public Boolean writeFeedback(Feedback feed);
}
