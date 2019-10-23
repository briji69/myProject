package com.capgemini.busbookingsystem.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.capgemini.busbookingsystem.beans.Admin;
import com.capgemini.busbookingsystem.beans.Booking;
import com.capgemini.busbookingsystem.beans.Bus;
import com.capgemini.busbookingsystem.beans.User;
import com.capgemini.busbookingsystem.common.CommonInfo;
import com.capgemini.busbookingsystem.common.CommonLoginInfo;
import com.capgemini.busbookingsystem.common.SearchBus;
import com.capgemini.busbookingsystem.exceptions.BookTicketException;
import com.capgemini.busbookingsystem.exceptions.CancelTicketException;
import com.capgemini.busbookingsystem.exceptions.GetBusException;
import com.capgemini.busbookingsystem.exceptions.ShowAllBusInfoException;
import com.capgemini.busbookingsystem.exceptions.ShowUserBookedTicketException;

public class BusBookingDAOImplementation implements BusBookingDAO {
	CommonInfo repo=new CommonInfo();
	CommonLoginInfo info = new CommonLoginInfo();
	SearchBus search = new SearchBus();
	private HashMap<Integer,Admin> adminInfo=info.adminInfo;
	private HashMap<Integer,User> usersInfo=info.usersInfo;
	private HashMap<Integer,Bus> busInfo=repo.busInfo;
	private HashMap<Integer,Booking> bookingInfo=repo.bookingInfo;
	
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
	public Boolean bookTicket(Booking ticket) {
		try {
			Random random=new Random();
			ticket.setTicket_id(random.nextInt());
			boolean state=false;

			if(ticket!=null){
				bookingInfo.put(ticket.getTicket_id(), ticket);
				System.out.println(ticket);
				state= true;
			}
			return state;
		}
		catch(Exception e)
		{
			throw new BookTicketException();
		}

	}	

	@Override
	public Boolean cancelTicket(int ticket_id) {
		try {
			if(bookingInfo.containsKey(ticket_id)){
				busInfo.remove(ticket_id);
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception e)
		{
			throw new CancelTicketException();
		}
	}

	@Override
	public List<Booking> showUserBookedTicket(int userID) {
		try {

			List<Booking> userTickets = new ArrayList<>();
			for(Integer bookingId : bookingInfo.keySet())
			{
				Booking ticket = bookingInfo.get(bookingId);
				if(ticket.getUser_id()==userID) {
					userTickets.add(ticket);
				}
			}
			return userTickets;
		}
		catch(Exception e)
		{
			throw new ShowUserBookedTicketException();
		}
	}
}
