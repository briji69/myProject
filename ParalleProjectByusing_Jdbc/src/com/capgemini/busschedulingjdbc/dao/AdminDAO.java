package com.capgemini.busschedulingjdbc.dao;

import com.capgemini.busschedulingjdbc.beans.User;

public interface AdminDAO {
	public User registerUser(User user);
	public boolean deleteUser(int userId);
}
