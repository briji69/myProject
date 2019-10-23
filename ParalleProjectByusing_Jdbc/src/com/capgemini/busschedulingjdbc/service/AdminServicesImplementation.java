package com.capgemini.busschedulingjdbc.service;

import com.capgemini.busschedulingjdbc.beans.User;
import com.capgemini.busschedulingjdbc.dao.AdminDAO;
import com.capgemini.busschedulingjdbc.dao.AdminDAOImplementation;

public class AdminServicesImplementation  implements AdminServices{

	AdminDAO adminDAO = new AdminDAOImplementation();
	@Override
	public User registerUser(User user) {
		return adminDAO.registerUser(user);
	}

	@Override
	public boolean deleteUser(int userId) {
		return adminDAO.deleteUser(userId);
	}

}
