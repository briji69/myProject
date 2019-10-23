package com.capgemini.busscheduling.services;

import java.util.Date;
import java.util.List;

import com.capgemini.busscheduling.dao.BusBookingDAO;
import com.capgemini.busscheduling.dao.BusBookingDAOImpl;
import com.capgemini.busscheduling.dao.CustomerDAO;
import com.capgemini.busscheduling.dao.CustomerDAOImpl;
import com.capgemini.busscheduling.dto.Availability;
import com.capgemini.busscheduling.dto.Feedback;
import com.capgemini.busscheduling.dto.Ticket;
import com.capgemini.busscheduling.dto.User;

public class CustomerServicesImpl implements CustomerService{

	CustomerDAO dao = new CustomerDAOImpl();
	BusBookingDAO bdao = new BusBookingDAOImpl();
	
	public User registerCustomer(User customer)  {
		return dao.registerCustomer(customer);
	}
	public User loginCustomer(Integer customerId, String password)  {
		return dao.loginCustomer(customerId, password);
	}
	public Boolean updateCustomer(User customer)  {
		return dao.updateCustomer(customer);
	}
	public Boolean deleteCustomer(Integer customerId)  {
		return dao.deleteCustomer(customerId);
	}
	public Ticket bookTicket(Ticket ticket)  {
		return dao.bookTicket(ticket);
	}
	public Boolean cancelTicket(Integer bookingId, Integer customerId) {
		return dao.cancelTicket(bookingId, customerId);
	}
	public Ticket getTicketInfo(Ticket bookingId) {
		return dao.getTicketInfo(bookingId);
	}
	public Integer checkAvailability(Integer busId, Date date) {
		return bdao.checkAvailability(busId, date);
	}
	public List<Availability> checkAvailability(String source, String destination,Date date) {
		return bdao.checkAvailability(source, destination, date);
	}
	public Boolean writeFeedback(Feedback feed) {
		return dao.writeFeedback(feed);
	}
	

}
