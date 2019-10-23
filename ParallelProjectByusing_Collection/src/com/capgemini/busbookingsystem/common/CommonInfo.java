package com.capgemini.busbookingsystem.common;

import java.util.HashMap;

import com.capgemini.busbookingsystem.beans.Admin;
import com.capgemini.busbookingsystem.beans.Booking;
import com.capgemini.busbookingsystem.beans.Bus;
import com.capgemini.busbookingsystem.beans.Owner;
import com.capgemini.busbookingsystem.beans.User;

public class CommonInfo {

	public static HashMap<Integer,Bus> busInfo=new HashMap<>();
	public static HashMap<Integer,Booking> bookingInfo=new HashMap<>();

	public CommonInfo(){
		
		//bus
		Bus bus1 = new Bus();
		bus1.setBus_id(9001);
		bus1.setBusname("srs");
		bus1.setSource("goa");
		bus1.setDestination("chennai");
		bus1.setTotal_seats(40);
		bus1.setBus_type("AC");
		bus1.setPrice(999);
		bus1.setAvailable_seats(bus1.getTotal_seats());
		busInfo.put(bus1.getBus_id(), bus1);

		Bus bus2=new Bus();
		bus2.setBus_id(9002);
		bus2.setBusname("volvo");
		bus2.setSource("chennai");
		bus2.setDestination("goa");
		bus2.setTotal_seats(50);
		bus2.setBus_type("AC");
		bus2.setPrice(1299);
		bus2.setAvailable_seats(bus2.getTotal_seats());
		busInfo.put(bus2.getBus_id(), bus2);
		
		

	}
}
