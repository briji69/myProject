package com.capgemini.busbookingsystem.dao;

import com.capgemini.busbookingsystem.exceptions.DeleteOwnerException;
import com.capgemini.busbookingsystem.exceptions.DeleteUserException;

public interface AdminDAO {
	public Boolean adminlogin(int admin_id, String adminpassword);
	public Boolean deleteUser(int user_id) throws DeleteUserException;
	public Boolean deleteOwner(int ownerId) throws DeleteOwnerException;
}
