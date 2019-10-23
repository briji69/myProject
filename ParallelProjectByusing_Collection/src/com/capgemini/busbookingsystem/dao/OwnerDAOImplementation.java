package com.capgemini.busbookingsystem.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.capgemini.busbookingsystem.beans.Admin;
import com.capgemini.busbookingsystem.beans.Bus;
import com.capgemini.busbookingsystem.beans.Owner;
import com.capgemini.busbookingsystem.common.CommonInfo;
import com.capgemini.busbookingsystem.common.CommonLoginInfo;
import com.capgemini.busbookingsystem.common.SearchBus;
import com.capgemini.busbookingsystem.exceptions.CreateBusException;
import com.capgemini.busbookingsystem.exceptions.CreateOwnerProfileException;
import com.capgemini.busbookingsystem.exceptions.CreateProfileException;
import com.capgemini.busbookingsystem.exceptions.DeleteBusException;
import com.capgemini.busbookingsystem.exceptions.GetBusException;
import com.capgemini.busbookingsystem.exceptions.OwnerLoginException;
import com.capgemini.busbookingsystem.exceptions.ShowAllBusInfoException;
import com.capgemini.busbookingsystem.exceptions.UpdateBusException;

public class OwnerDAOImplementation implements OwnerDAO {
	
	SearchBus search = new SearchBus();
	CommonInfo repo=new CommonInfo();
	CommonLoginInfo info = new CommonLoginInfo();
	private HashMap<Integer,Owner> ownerInfo=info.ownerInfo;
	
	private HashMap<Integer,Bus> busInfo=repo.busInfo;
	
	
	@Override
	public Boolean ownerLogin(int ownerId, String ownerPassword) {
		try {
			// Owner login
			if(ownerInfo.containsKey(ownerId)){
				Owner owner=ownerInfo.get(ownerId);
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception e)
		{
			throw new OwnerLoginException();
		}
	}
	
	@Override
	public Boolean createBus(Bus bus) {
		try {
			if(busInfo.containsKey(bus.getBus_id())==false){
				busInfo.put(bus.getBus_id(), bus);
				return true;
			}else{
				return false;
			}
		}
		catch(Exception e)
		{
			throw new CreateBusException();
		}
	}

	@Override
	public Boolean updateBus(Bus bus) {
		try {
			if(busInfo.containsKey(bus.getBus_id())){
				busInfo.put(bus.getBus_id(), bus);
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception e)
		{
			throw new UpdateBusException();
		}
	}

	@Override
	public Boolean deleteBus(int bus_id) {
		try {
			if(busInfo.containsKey(bus_id)){
				busInfo.remove(bus_id);
				
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception e)
		{
			throw new DeleteBusException();
		}
	}

	@Override
	public Bus getBus(int bus_id) {
		return search.getBus(bus_id);
	}

	@Override
	public List<Integer> showAllBusInfo() {
		try {
			List<Integer> allBus = new ArrayList<>();
			for(Integer bookingId : busInfo.keySet())
			{
				Bus bus = busInfo.get(bookingId);
				allBus.add(bookingId);

			}
			return allBus;
		}
		catch(Exception e)
		{
			throw new ShowAllBusInfoException();
		}
	}
	@Override
	public boolean updateAvailability(int bus_id, int seats) {
		Bus bus = getBus(bus_id);
		if(busInfo.containsKey(bus_id)){
			bus.setAvailable_seats(bus.getAvailable_seats()-seats);
		}
		else{
			return false;
		}
		return false;


	}
}
