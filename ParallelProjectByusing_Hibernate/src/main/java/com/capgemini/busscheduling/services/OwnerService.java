package com.capgemini.busscheduling.services;

import java.util.Date;
import java.util.List;

import com.capgemini.busscheduling.dto.Availability;
import com.capgemini.busscheduling.dto.Bus;
import com.capgemini.busscheduling.dto.Ticket;
import com.capgemini.busscheduling.dto.User;

public interface OwnerService {

	public User loginOwner(Integer ownerId, String password) ;
	public Bus addBus(Bus bus);
	public Boolean updateBus(Bus bus) ;
	public Boolean deleteBus(Integer busId) ;
	public List<Ticket>getTicketByBus(Integer busId,Date date);
	public List<Ticket>getAllTicket(Integer userId);
	public Boolean setBusAvailability(Availability availability) ;
}
