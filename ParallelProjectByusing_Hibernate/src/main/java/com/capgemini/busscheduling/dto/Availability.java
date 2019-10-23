package com.capgemini.busscheduling.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "avail_details")
public class Availability {
	@Column(name = "avail_date")
	private Date availableDate;
	@Column(name = "avail_seat")
	private Integer availableSeat;
	@Id
	@Column(name = "bus_id")
	private Integer busId;
	
	public Date getAvailableDate() {
		return availableDate;
	}
	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}
	public Integer getAvailableSeat() {
		return availableSeat;
	}
	public void setAvailableSeat(Integer availableSeat) {
		this.availableSeat = availableSeat;
	}
	public Integer getBusId() {
		return busId;
	}
	public void setBusId(Integer busId) {
		this.busId = busId;
	}
	@Override
	public String toString() {
		return "Availability [availableDate=" + availableDate + ", availableSeat=" + availableSeat + ", busId=" + busId
				+ "]";
	}

	
}
