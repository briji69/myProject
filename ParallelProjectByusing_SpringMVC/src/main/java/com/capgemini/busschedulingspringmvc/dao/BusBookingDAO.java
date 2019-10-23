package com.capgemini.busschedulingspringmvc.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.busschedulingspringmvc.beans.Availability;
import com.capgemini.busschedulingspringmvc.beans.Feedback;


public interface BusBookingDAO {

	public List<Availability>checkAvailability(String source, String destination, Date date);
	public List<Feedback> viewFeedback();



}