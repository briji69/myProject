package com.capgemini.busscheduling.services;

import java.util.Date;
import java.util.List;

import com.capgemini.busscheduling.dto.Availability;
import com.capgemini.busscheduling.dto.Bus;
import com.capgemini.busscheduling.dto.Ticket;
import com.capgemini.busscheduling.dto.User;
import com.capgemini.busscheduling.dao.OwnerDAO;
import com.capgemini.busscheduling.dao.OwnerDAOImpl;

public class OwnerServiceImpl implements OwnerService{

	OwnerDAO dao = new OwnerDAOImpl();

	public User loginOwner(Integer userId, String password)  {
		return dao.loginOwner(userId, password);
	}

	public Bus addBus(Bus bus)  {
		return dao.addBus(bus);
	}

	public Boolean updateBus(Bus bus)  {
		return dao.updateBus(bus);
	}

	public Boolean deleteBus(Integer busId)  {
		return dao.deleteBus(busId);
	}

	public List<Ticket> getTicketByBus(Integer busId, Date date) {
		return dao.getTicketByBus(busId, date);
	}

	public List<Ticket> getAllTicket(Integer userId) {
		return dao.getAllTicket(userId);
	}

	public Boolean setBusAvailability(Availability availability)  {
		return dao.setBusAvailability(availability);
	}
}
