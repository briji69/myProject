package com.capgemini.busschedulingjdbc.service;

import java.util.Date;
import java.util.List;

import com.capgemini.busschedulingjdbc.beans.Bus;
import com.capgemini.busschedulingjdbc.beans.Ticket;
import com.capgemini.busschedulingjdbc.dao.OwnerDAO;
import com.capgemini.busschedulingjdbc.dao.OwnerDAOImplementation;

public class OwnerServicesImplementation implements OwnerServices{

	OwnerDAO ownerDAO = new OwnerDAOImplementation();
	@Override
	public Bus addBus(Bus bus) {
		return ownerDAO.addBus(bus);
	}

	@Override
	public boolean updateBus(Bus bus) {
		return ownerDAO.updateBus(bus);
	}

	@Override
	public boolean deleteBus(int busId) {
		return ownerDAO.deleteBus(busId);
	}

	@Override
	public List<Ticket> getTicketByBusId(int busId, java.util.Date journeyDate) {
		return ownerDAO.getTicketByBusId(busId,  journeyDate);
	}

}
