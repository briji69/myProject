package com.capgemini.busschedulingjdbc.beans;

public class Feedback {
	private int userId;
	private int busId;
	private String feedback;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	@Override
	public String toString() {
		return "Feedback [userId=" + userId + ", busId=" + busId + ", feedback=" + feedback + "]";
	}
	
}
