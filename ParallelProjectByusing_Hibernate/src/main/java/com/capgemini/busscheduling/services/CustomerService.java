package com.capgemini.busscheduling.services;

import java.util.Date;
import java.util.List;

import com.capgemini.busscheduling.dto.Availability;
import com.capgemini.busscheduling.dto.Feedback;
import com.capgemini.busscheduling.dto.Ticket;
import com.capgemini.busscheduling.dto.User;

public interface CustomerService {

	public User registerCustomer( User customer) ;
	public User loginCustomer(Integer customerId, String password) ;
	public Boolean updateCustomer(User customer) ;
	public Boolean deleteCustomer(Integer customerId) ;
	public Ticket bookTicket(Ticket ticket) ;
	public Boolean cancelTicket(Integer bookingId, Integer customerId);
	public Ticket getTicketInfo(Ticket bookingId);
	public Integer checkAvailability(Integer busId, Date date);
	public List<Availability>checkAvailability(String source, String destination, Date date);
	public Boolean writeFeedback(Feedback feed);
}
