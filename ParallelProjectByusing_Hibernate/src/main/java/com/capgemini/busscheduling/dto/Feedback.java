package com.capgemini.busscheduling.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback_details")
public class Feedback {
	@Id
	@Column(name = "customer_id")
	private Integer customerId;
	@Column(name = "feedback")
	private String feedback;

	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Feedback [customerId=" + customerId + ", feedback=" + feedback + "]";
	}
}
