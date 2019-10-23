package com.capgemini.busschedulingspringmvc.service;

import java.util.Date;
import java.util.List;

import com.capgemini.busschedulingspringmvc.beans.Availability;
import com.capgemini.busschedulingspringmvc.beans.Feedback;


public interface BusBookingService {

	public List<Availability>checkAvailability(String source, String destination, Date date);
	public List<Feedback> viewFeedback();


}