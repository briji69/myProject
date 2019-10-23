package com.capgemini.busbookingsystem.beans;

public class Owner {
	private String ownerName;
	private int ownerId;
	private String ownerPassword;
	private String ownerEmail;
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerPassword() {
		return ownerPassword;
	}
	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	
	@Override
	public String toString() {
		return "Owner [ownerName=" + ownerName + "\n ownerId=" + ownerId + "\n ownerEmail=" + ownerEmail + "]";
	}
	
}
