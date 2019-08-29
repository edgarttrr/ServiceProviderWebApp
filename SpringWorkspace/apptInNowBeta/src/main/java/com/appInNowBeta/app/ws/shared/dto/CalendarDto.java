package com.appInNowBeta.app.ws.shared.dto;

import java.io.Serializable;

public class CalendarDto implements Serializable {

	private static final long serialVersionUID = 6592879162083922404L;
	
	private String userId;
	private String businessName;
	private String zipCode;
	private String phoneNumber;
	private String email;
	private String yelpLink;
	private String cost;
	private String datepicker;
	private String timepicker;
	private String category;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
