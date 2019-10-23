package com.capgemini.busbookingsystem.dao;

import java.util.List;

import com.capgemini.busbookingsystem.beans.Admin;
import com.capgemini.busbookingsystem.beans.Booking;
import com.capgemini.busbookingsystem.beans.Bus;
import com.capgemini.busbookingsystem.beans.User;
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
import com.capgemini.busbookingsystem.exceptions.ShowUserBookedTicketException;
import com.capgemini.busbookingsystem.exceptions.UpdateAvailabilityException;
import com.capgemini.busbookingsystem.exceptions.UpdateBusException;
import com.capgemini.busbookingsystem.exceptions.UpdateUserException;

public interface UserDAO{

	//User Manipulation
	public Boolean createUser(User user) throws CreateProfileException;
	public Boolean updateUser(User user) throws UpdateUserException;
	public Boolean deleteUser(int userID) throws DeleteUserException;
	public Boolean loginUser(int user_id, String password) throws LoginUserException;;
	public User searchUser(int userID) throws SearchUserException;

	public Bus getBus(int bus_id); 
	public List<Integer> showAllBusInfo(); 



	//ticket booking
	public Boolean bookTicket(Booking ticket);
	public Boolean cancelTicket(int ticket_id);
	public List<Booking> showUserBookedTicket(int userID);

	public boolean updateAvailability(int bus_id, int seats) throws UpdateAvailabilityException;

}
