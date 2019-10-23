package com.capgemini.busschedulingjdbc.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.busschedulingjdbc.beans.Bus;
import com.capgemini.busschedulingjdbc.beans.Ticket;
import com.capgemini.busschedulingjdbc.beans.User;

public interface OwnerDAO {
	public Bus addBus(Bus bus);
	public boolean updateBus(Bus bus);
	public boolean deleteBus(int busId);
	public List<Ticket> getTicketByBusId(int busId, java.util.Date journeyDate);
}
