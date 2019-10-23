package com.capgemini.busbookingsystem.services;

public interface AdminServices {
	public Boolean adminlogin(int admin_id, String adminpassword);
	public Boolean deleteUser(int user_id);
	public Boolean deleteOwner(int ownerId);
	
	public Integer regex (String id);
	public String regexemail (String email);
	public String regexcontact (String contact);
}
