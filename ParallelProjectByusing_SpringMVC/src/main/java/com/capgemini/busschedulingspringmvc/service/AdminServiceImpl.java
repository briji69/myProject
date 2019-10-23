package com.capgemini.busschedulingspringmvc.service;


import com.capgemini.busschedulingspringmvc.beans.User;
import com.capgemini.busschedulingspringmvc.dao.AdminDAO;
import com.capgemini.busschedulingspringmvc.dao.AdminDAOImpl;
public class AdminServiceImpl implements AdminService{

	AdminDAO adminDAO=new AdminDAOImpl();
	
	@Override
	public User adminLogin(Integer adminId, String password)  {
		return adminDAO.adminLogin(adminId, password);
	}
	@Override
	public User registerOwner(User user)  {
		return adminDAO.registerOwner(user);
	}
	@Override
	public Boolean deleteCustomer(Integer userId)  {
		return adminDAO.deleteCustomer(userId);
	}
	@Override
	public Boolean deleteOwner(Integer ownerId)  {
		return adminDAO.deleteOwner(ownerId);
	}
}
