package com.capgemini.busbookingsystem.services;

import java.util.List;

import com.capgemini.busbookingsystem.beans.Bus;

public interface OwnerService {

	public Boolean ownerLogin(int ownerId, String ownerPassword);
	public Boolean createBus(Bus bus);
	public Boolean updateBus(Bus bus);
	public Boolean deleteBus(int bus_id);
	public Bus getBus(int bus_id);
	public List<Integer> showAllBusInfo();
	public boolean updateAvailability(int bus_id, int seats);
	
	public Integer regex (String id);
	public String regexemail (String email);
	public String regexcontact (String contact);
}
