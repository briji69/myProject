package com.capgemini.busbookingsystem.services;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.busbookingsystem.beans.Admin;
import com.capgemini.busbookingsystem.beans.Booking;
import com.capgemini.busbookingsystem.beans.Bus;
import com.capgemini.busbookingsystem.beans.User;
import com.capgemini.busbookingsystem.common.SearchBus;
import com.capgemini.busbookingsystem.dao.UserDAO;
import com.capgemini.busbookingsystem.dao.UserDAOImplementation;
import com.capgemini.busbookingsystem.utils.ValidationsRegEx;
import com.capgemini.busbookingsystem.utils.ValidationsRegExImplementation;

public class UserServicesImplementation implements UserServices {
	
	OwnerService owner = new OwnerServiceImplementation();
	UserDAO dao=new UserDAOImplementation();
	SearchBus search = new SearchBus();
	ValidationsRegEx validation = new ValidationsRegExImplementation();
	
	@Override
	public Boolean createUser(User user) {
		return dao.createUser(user);
		}

	@Override
	public Boolean updateUser(User user) {
		return dao.updateUser(user);
	}

	@Override
	public Boolean deleteUser(int userID) {
		return dao.deleteUser(userID);
	}

	@Override
	public Boolean loginUser(int user_id, String password) {
		return dao.loginUser(user_id, password);
	}

	@Override
	public User searchUser(int userID) {
		return dao.searchUser(userID);
	}

	
	@Override
	public Bus getBus(int bus_id) {
		return owner.getBus(bus_id);
	}
	
	@Override
	public List<Integer> showAllBusInfo() {
		return owner.showAllBusInfo();
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
		return dao.updateAvailability(bus_id, seats);
	}


	//RegEx
	@Override
	public Integer regex(String id) {
		return validation.regex(id);
	}

	@Override
	public String regexemail(String email) {
		return validation.regexemail(email);
	}

	@Override
	public String regexcontact(String contact) {
		return validation.regexcontact(contact);
	}	
}
