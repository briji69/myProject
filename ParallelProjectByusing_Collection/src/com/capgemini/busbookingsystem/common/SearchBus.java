package com.capgemini.busbookingsystem.common;

import java.util.HashMap;

import com.capgemini.busbookingsystem.beans.Bus;
import com.capgemini.busbookingsystem.exceptions.GetBusException;

public class SearchBus {
	CommonInfo repo=new CommonInfo();
	private HashMap<Integer,Bus> busInfo=repo.busInfo;
	public Bus getBus(int bus_id) {
		try {
			if(busInfo.containsKey(bus_id)){
				return busInfo.get(bus_id);
			}
			else{
				return null;
			}
		}
		catch(Exception e)
		{
			throw new GetBusException();
		}
	}
}
