package com.capgemini.busbookingsystem.dao;

import java.util.HashMap;

import com.capgemini.busbookingsystem.beans.Admin;
import com.capgemini.busbookingsystem.beans.Owner;
import com.capgemini.busbookingsystem.beans.User;
import com.capgemini.busbookingsystem.common.CommonInfo;
import com.capgemini.busbookingsystem.common.CommonLoginInfo;
import com.capgemini.busbookingsystem.exceptions.AdminloginException;
import com.capgemini.busbookingsystem.exceptions.DeleteOwnerException;
import com.capgemini.busbookingsystem.exceptions.DeleteUserException;

public class AdminDAOImplementation implements AdminDAO {
	
	CommonLoginInfo info = new CommonLoginInfo();
	
	private HashMap<Integer,Admin> adminInfo=info.adminInfo;
	private HashMap<Integer,User> usersInfo=info.usersInfo;
	private HashMap<Integer,Owner> ownerInfo=info.ownerInfo;
	@Override
	public Boolean adminlogin(int admin_id, String adminpassword) {
		try {
			// Admin login
			if(adminInfo.containsKey(admin_id)){
				Admin admin=adminInfo.get(admin_id);
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception e)
		{
			throw new AdminloginException();
		}
	}
	
	@Override
	public Boolean deleteUser(int userID) {
		try {
			if(usersInfo.containsKey(userID)){
				usersInfo.remove(userID);
				return true;
			}else{
				return false;
			}
		}
		catch(Exception e)
		{
			throw new DeleteUserException();
		}
	}
	public Boolean deleteOwner(int ownerId) throws DeleteOwnerException {
		try {
			if(ownerInfo.containsKey(ownerId)){
				ownerInfo.remove(ownerId);
				return true;
			}else{
				return false;
			}
		}
		catch(Exception e)
		{
			throw new DeleteOwnerException();
		}
	}
}
