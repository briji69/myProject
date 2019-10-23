package com.capgemini.busschedulingspringmvc.service;

import com.capgemini.busschedulingspringmvc.beans.User;

public interface AdminService {

	public User adminLogin(Integer adminId, String password)  ;
	public User registerOwner( User user)  ;
	public Boolean deleteCustomer(Integer userId) ;
	public Boolean deleteOwner(Integer userId) ;
}
