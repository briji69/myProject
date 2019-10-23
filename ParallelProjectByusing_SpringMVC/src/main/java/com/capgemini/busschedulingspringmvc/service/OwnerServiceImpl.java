package com.capgemini.busschedulingspringmvc.service;

import java.util.List;


import com.capgemini.busschedulingspringmvc.beans.Availability;
import com.capgemini.busschedulingspringmvc.beans.Bus;
import com.capgemini.busschedulingspringmvc.beans.Ticket;
import com.capgemini.busschedulingspringmvc.dao.OwnerDAO;
import com.capgemini.busschedulingspringmvc.dao.OwnerDAOImpl;

public class OwnerServiceImpl implements OwnerService{
	OwnerDAO ownerDAO=new OwnerDAOImpl();
	@Override
	public Bus searchBus(Integer busId) {
		return ownerDAO.searchBus(busId);
	}
	@Override
	public Bus addBus(Bus bus)  {
		return ownerDAO.addBus(bus);
	}
	@Override
	public Boolean updateBus(Bus bus)  {
		return ownerDAO.updateBus(bus);
	}
	@Override
	public Boolean deleteBus(Integer busId)  {
		return ownerDAO.deleteBus(busId);
	}
	@Override
	public List<Ticket> getAllTicket() {
		return ownerDAO.getAllTicket();
	}
	@Override
	public Boolean setBusAvailability(Availability availability)  {
		return ownerDAO.setBusAvailability(availability);
	}
}
