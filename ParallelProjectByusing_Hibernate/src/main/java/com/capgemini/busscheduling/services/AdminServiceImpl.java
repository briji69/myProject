package com.capgemini.busscheduling.services;

import com.capgemini.busscheduling.dto.User;
import com.capgemini.busscheduling.dao.AdminDAO;
import com.capgemini.busscheduling.dao.AdminDAOImpl;

public class AdminServiceImpl implements AdminService{

	AdminDAO dao = new AdminDAOImpl();

	public User adminLogin(Integer adminId, String password)  {
		return dao.adminLogin(adminId, password);
	}

	public User registerOwner(User owner)  {
		return dao.registerOwner(owner);
	}

	public Boolean deleteCustomer(Integer userId)  {
		return dao.deleteCustomer(userId);
	}

	public Boolean deleteOwner(Integer ownerId)  {
		return dao.deleteOwner(ownerId);
	}

	



}
