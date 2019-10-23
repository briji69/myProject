package com.capgemini.busbookingsystem.beans;

public class Admin {

	private int admin_id;
	private String adminpassword;
	
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", adminpassword=" + adminpassword + "]";
	}


	
}
