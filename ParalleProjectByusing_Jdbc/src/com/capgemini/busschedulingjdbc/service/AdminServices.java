package com.capgemini.busschedulingjdbc.service;

import com.capgemini.busschedulingjdbc.beans.User;

public interface AdminServices {
	public User registerUser(User user);
	public boolean deleteUser(int userId);
}
