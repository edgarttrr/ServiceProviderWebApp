package com.appInNowBeta.app.ws.io.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "calendar")
public class CalendarEntity implements Serializable {
	
	private static final long serialVersionUID = 7603428141881962795L;
	
	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false,length = 100)
	private String userId;

	@Column(nullable = false, length = 50)
	private String businessName;

	@Column(nullable = false, length = 100)
	private String datepicker;
	
	@Column(nullable = false, length = 100)
	private String timepicker;
	
	@Column(nullable = false, length = 100)
	private String zipCode;

	@Column(nullable = false, length = 100)
	private String phoneNumber;
	
	@Column(nullable = false, length = 120)
	private String email;
	
	@Column(nullable = false, length = 500)
	private String yelpLink;
	
	@Column(nullable = false, length = 100)
	private String cost;
	
	@Column(nullable = false, length = 100)
	private String category;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getDatepicker() {
		return datepicker;
	}

	public void setDatepicker(String datepicker) {
		this.datepicker = datepicker;
	}
	
	public String getTimepicker() {
		return timepicker;
	}

	public void setTimepicker(String timepicker) {
		this.timepicker = timepicker;
	}
	
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getYelpLink() {
		return yelpLink;
	}
	
	public void setYelpLink(String yelpLink) {
		this.yelpLink = yelpLink;
	}
	
	public String getCost() {
		return cost;
	}
	
	public void setCost(String cost) {
		this.cost = cost;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	

}
