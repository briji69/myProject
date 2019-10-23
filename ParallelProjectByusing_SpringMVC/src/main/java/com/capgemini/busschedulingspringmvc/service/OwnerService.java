package com.capgemini.busschedulingspringmvc.service;

import java.util.List;

import com.capgemini.busschedulingspringmvc.beans.Availability;
import com.capgemini.busschedulingspringmvc.beans.Bus;
import com.capgemini.busschedulingspringmvc.beans.Ticket;


public interface OwnerService {
	public Bus searchBus(Integer busId);
	public Bus addBus(Bus bus);
	public Boolean updateBus(Bus bus) ;
	public Boolean deleteBus(Integer busId) ;
	public List<Ticket>getAllTicket();
	public Boolean setBusAvailability(Availability availability) ;
}
