package com.capgemini.busschedulingspringmvc.service;

import java.util.Date;
import java.util.List;


import com.capgemini.busschedulingspringmvc.beans.Availability;
import com.capgemini.busschedulingspringmvc.beans.Feedback;
import com.capgemini.busschedulingspringmvc.dao.BusBookingDAO;
import com.capgemini.busschedulingspringmvc.dao.BusBookingDAOImpl;

public class BusBookingServiceImpl implements BusBookingService {
	BusBookingDAO busBookingDAO=new BusBookingDAOImpl();
	
	
	@Override
	public List<Availability> checkAvailability(String source, String destination,Date date) {
		return busBookingDAO.checkAvailability(source, destination, date);
	}
	@Override
	public List<Feedback> viewFeedback() {
		return busBookingDAO.viewFeedback();
	}




}