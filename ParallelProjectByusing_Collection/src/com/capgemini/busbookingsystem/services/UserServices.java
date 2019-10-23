package com.capgemini.busbookingsystem.services;

import java.util.List;

import com.capgemini.busbookingsystem.beans.Admin;
import com.capgemini.busbookingsystem.beans.Booking;
import com.capgemini.busbookingsystem.beans.Bus;
import com.capgemini.busbookingsystem.beans.User;

public interface UserServices {
			
	//User Manipulation
	public Boolean createUser(User user);
	public Boolean updateUser(User user);
	public Boolean deleteUser(int userID);
	public Boolean loginUser(int user_id, String password);
	public User searchUser(int userID);
	
	public Bus getBus(int bus_id);
	public List<Integer> showAllBusInfo();
	
	//ticket booking
	public Boolean bookTicket(Booking ticket);
	public List<Booking> showUserBookedTicket(int userID);

	public Boolean cancelTicket(int ticket_id);
	public boolean updateAvailability(int bus_id, int seats);
	
	//RegEx
		public Integer regex (String id);
		public String regexemail (String email);
		public String regexcontact (String contact);

	
}