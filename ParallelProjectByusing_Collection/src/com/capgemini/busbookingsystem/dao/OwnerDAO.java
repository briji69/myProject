package com.capgemini.busbookingsystem.dao;

import java.util.List;

import com.capgemini.busbookingsystem.beans.Bus;
import com.capgemini.busbookingsystem.beans.Owner;
import com.capgemini.busbookingsystem.beans.User;
import com.capgemini.busbookingsystem.exceptions.CreateBusException;
import com.capgemini.busbookingsystem.exceptions.CreateOwnerProfileException;
import com.capgemini.busbookingsystem.exceptions.CreateProfileException;
import com.capgemini.busbookingsystem.exceptions.DeleteBusException;
import com.capgemini.busbookingsystem.exceptions.GetBusException;
import com.capgemini.busbookingsystem.exceptions.OwnerLoginException;
import com.capgemini.busbookingsystem.exceptions.UpdateAvailabilityException;
import com.capgemini.busbookingsystem.exceptions.UpdateBusException;

public interface OwnerDAO {
	public Boolean ownerLogin(int ownerId, String ownerPassword)throws OwnerLoginException;
	public Boolean createBus(Bus bus) throws CreateBusException;
	public Boolean updateBus(Bus bus) throws UpdateBusException;
	public Boolean deleteBus(int bus_id) throws DeleteBusException;
	public Bus getBus(int bus_id);
	public List<Integer> showAllBusInfo() throws CreateBusException;
	public boolean updateAvailability(int bus_id, int seats) throws UpdateAvailabilityException;
}
