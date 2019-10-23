package com.capgemini.busscheduling.services;

import java.util.Date;
import java.util.List;

import com.capgemini.busscheduling.dto.Availability;
import com.capgemini.busscheduling.dto.Bus;
import com.capgemini.busscheduling.dto.Feedback;
import com.capgemini.busscheduling.util.Validator;
import com.capgemini.busscheduling.dao.BusBookingDAO;
import com.capgemini.busscheduling.dao.BusBookingDAOImpl;

public class BusBookingServiceImpl implements BusBookingService {

	BusBookingDAO dao = new BusBookingDAOImpl();
	Validator validator=new Validator();
	  public Bus searchBus(Integer busId) {
		return dao.searchBus(busId);
	}
	  public Integer checkAvailability(Integer busId, Date date) {
		return dao.checkAvailability(busId, date);
	}

	public List<Availability> checkAvailability(String source, String destination,Date date) {
		return dao.checkAvailability(source, destination, date);
	}

	public List<Feedback> viewFeedback() {
		return dao.viewFeedback();
	}

	public Integer validateId(String id) {
		return validator.validateId(id);
	}

	public String validateEmail(String email) {
		return validator.validateEmail(email);
	}

	public Long validateContact(String contact) {
		return validator.validateContact(contact);
	}

	



}