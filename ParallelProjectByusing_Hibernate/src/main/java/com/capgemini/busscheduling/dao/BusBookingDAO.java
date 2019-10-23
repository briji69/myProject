package com.capgemini.busscheduling.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.busscheduling.dto.Availability;
import com.capgemini.busscheduling.dto.Bus;
import com.capgemini.busscheduling.dto.Feedback;

public interface BusBookingDAO {

	public Bus searchBus(Integer busId);
	public Integer checkAvailability(Integer busId, Date date);
	public List<Availability>checkAvailability(String source, String destination, Date date);
	public List<Feedback> viewFeedback();



}