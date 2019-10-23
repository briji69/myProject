package com.capgemini.busschedulingspringmvc.dao;

import com.capgemini.busschedulingspringmvc.beans.User;

public interface AdminDAO {
	public User adminLogin(Integer adminId, String password)  ;
	public User registerOwner( User owner)  ;
	public Boolean deleteCustomer(Integer customerId)  ;
	public Boolean deleteOwner(Integer ownerId) ;
	
}
