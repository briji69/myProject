package com.capgemini.busschedulingspringmvc.service;



import com.capgemini.busschedulingspringmvc.beans.Feedback;
import com.capgemini.busschedulingspringmvc.beans.Ticket;
import com.capgemini.busschedulingspringmvc.beans.User;
import com.capgemini.busschedulingspringmvc.dao.BusBookingDAO;
import com.capgemini.busschedulingspringmvc.dao.BusBookingDAOImpl;
import com.capgemini.busschedulingspringmvc.dao.CustomerDAO;
import com.capgemini.busschedulingspringmvc.dao.CustomerDAOImpl;

public class CustomerServicesImpl implements CustomerService{
	CustomerDAO customerDAO=new CustomerDAOImpl();
	BusBookingDAO busBookingDAO=new BusBookingDAOImpl();

	@Override
	public Boolean updateCustomer(User user)  {
		return customerDAO.updateCustomer(user);
	}
	@Override
	public Boolean deleteCustomer(Integer customerId)  {
		return customerDAO.deleteCustomer(customerId);
	}
	@Override
	public Ticket bookTicket(Ticket ticket)  {
		return customerDAO.bookTicket(ticket);
	}
	@Override
	public Boolean cancelTicket(Integer bookingId, Integer customerId) {
		return customerDAO.cancelTicket(bookingId, customerId);
	}
	@Override
	public Ticket getTicketInfo(Integer bookingId) {
		return customerDAO.getTicketInfo(bookingId);
	}
	
	@Override
	public Boolean writeFeedback(Feedback feed) {
		return customerDAO.writeFeedback(feed);
	}


}
