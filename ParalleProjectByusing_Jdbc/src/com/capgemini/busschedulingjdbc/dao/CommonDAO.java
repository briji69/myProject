package com.capgemini.busschedulingjdbc.dao;

import java.util.List;

import com.capgemini.busschedulingjdbc.beans.Bus;
import com.capgemini.busschedulingjdbc.beans.Feedback;
import com.capgemini.busschedulingjdbc.beans.User;

public interface CommonDAO {
	public List<Bus> exploreBus(String source, String destination);
	public List<Feedback> viewFeedback();
	public User login(int userId, String password);
	public boolean updateUser(User user);
	
}
