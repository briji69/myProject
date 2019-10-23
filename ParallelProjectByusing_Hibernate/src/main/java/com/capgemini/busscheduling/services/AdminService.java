package com.capgemini.busscheduling.services;

import com.capgemini.busscheduling.dto.User;

public interface AdminService {

	public User adminLogin(Integer adminId, String password)  ;
	public User registerOwner( User owner)  ;
	public Boolean deleteCustomer(Integer userId) ;
	public Boolean deleteOwner(Integer userId) ;
}
