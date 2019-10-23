package com.capgemini.busbookingsystem.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.capgemini.busbookingsystem.beans.Admin;
import com.capgemini.busbookingsystem.beans.Booking;
import com.capgemini.busbookingsystem.beans.Bus;
import com.capgemini.busbookingsystem.beans.User;
import com.capgemini.busbookingsystem.common.*;
import com.capgemini.busbookingsystem.exceptions.AdminloginException;
import com.capgemini.busbookingsystem.exceptions.BookTicketException;
import com.capgemini.busbookingsystem.exceptions.CancelTicketException;
import com.capgemini.busbookingsystem.exceptions.CheckAvailabilityException;
import com.capgemini.busbookingsystem.exceptions.CreateBusException;
import com.capgemini.busbookingsystem.exceptions.CreateProfileException;
import com.capgemini.busbookingsystem.exceptions.DeleteBusException;
import com.capgemini.busbookingsystem.exceptions.DeleteUserException;
import com.capgemini.busbookingsystem.exceptions.GetBusException;
import com.capgemini.busbookingsystem.exceptions.LoginUserException;
import com.capgemini.busbookingsystem.exceptions.SearchUserException;
import com.capgemini.busbookingsystem.exceptions.ShowAllBusInfoException;
import com.capgemini.busbookingsystem.exceptions.ShowUserBookedTicketException;
import com.capgemini.busbookingsystem.exceptions.UpdateBusException;
import com.capgemini.busbookingsystem.exceptions.UpdateUserException;

public class UserDAOImplementation implements UserDAO{
	SearchBus search = new SearchBus();
	BusBookingDAO dao = new BusBookingDAOImplementation();
	CommonInfo repo=new CommonInfo();
	CommonLoginInfo info = new CommonLoginInfo();
	private HashMap<Integer,Admin> adminInfo=info.adminInfo;
	private HashMap<Integer,User> usersInfo=info.usersInfo;
	private HashMap<Integer,Bus> busInfo=repo.busInfo;
	private HashMap<Integer,Booking> bookingInfo=repo.bookingInfo; 

	@Override
	public Boolean createUser(User user) {
		try {
			if(usersInfo.containsKey(user.getUser_id())==false){
				usersInfo.put(user.getUser_id(), user);
				return true;
			}else{
				return false;
			}
		}
		catch(Exception e)
		{
			throw new CreateProfileException();
		}
	}

	@Override
	public Boolean updateUser(User user) {
		try {
			if(usersInfo.containsKey(user.getUser_id())){
				usersInfo.put(user.getUser_id(), user);
				return true;
			}else{
				return false;
			}
		}
		catch(Exception e)
		{
			throw new UpdateUserException();
		}
	}

	@Override
	public Boolean deleteUser(int userID) {
		try {
			if(usersInfo.containsKey(userID)){
				usersInfo.remove(userID);
				return true;
			}else{
				return false;
			}
		}
		catch(Exception e)
		{
			throw new DeleteUserException();
		}
	}

	@Override
	public Boolean loginUser(int user_id, String password) {
		try {
			if(usersInfo.containsKey(user_id)){
				User user=usersInfo.get(user_id);
				if(user.getPassword().equals(password)){
					return true;
				}
			}
			return false;
		}
		catch(Exception e)
		{
			throw new LoginUserException();
		}
	}

	@Override
	public User searchUser(int userID) {
		try {
			if(usersInfo.containsKey(userID)){
				return usersInfo.get(userID);
			}
			return null;
		}
		catch(Exception e)
		{
			throw new SearchUserException();
		}
	}

	@Override
	public Bus getBus(int bus_id) {
		return search.getBus(bus_id);
	}

	@Override
	public List<Integer> showAllBusInfo() {
		return dao.showAllBusInfo();
	}


	@Override
	public Boolean bookTicket(Booking ticket) {
		return dao.bookTicket(ticket);

	}	

	@Override
	public Boolean cancelTicket(int ticket_id) {
		return dao.cancelTicket(ticket_id);
	}

	@Override
	public List<Booking> showUserBookedTicket(int userID) {
		return dao.showUserBookedTicket(userID);
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
