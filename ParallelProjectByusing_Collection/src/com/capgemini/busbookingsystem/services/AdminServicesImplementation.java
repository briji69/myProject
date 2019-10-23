package com.capgemini.busbookingsystem.services;

import com.capgemini.busbookingsystem.dao.AdminDAO;
import com.capgemini.busbookingsystem.dao.AdminDAOImplementation;
import com.capgemini.busbookingsystem.utils.ValidationsRegEx;
import com.capgemini.busbookingsystem.utils.ValidationsRegExImplementation;

public class AdminServicesImplementation implements AdminServices {
	AdminDAO dao=new AdminDAOImplementation();
	ValidationsRegEx validation = new ValidationsRegExImplementation();
	@Override
	public Boolean adminlogin(int admin_id, String adminpassword) {
		return dao.adminlogin(admin_id, adminpassword);	}
	@Override
	public Boolean deleteUser(int user_id) {
		
		return dao.deleteUser(user_id);
	}
	@Override
	public Boolean deleteOwner(int ownerId) {

		return dao.deleteOwner(ownerId);
	}
	
	@Override
	public Integer regex(String id) {
		return validation.regex(id);
	}

	@Override
	public String regexemail(String email) {
		return validation.regexemail(email);
	}

	@Override
	public String regexcontact(String contact) {
		return validation.regexcontact(contact);
	}
}
