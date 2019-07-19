package com.appInNowBeta.app.ws.ui.model.response;

public class User {

	private String userId;
	private String businessName;
	private String cost;
	private String email;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBusinessNam() {
		return businessName;
	}

	public void setFirstName(String firstName) {
		this.businessName = firstName;
	}

	public String getLastName() {
		return cost;
	}

	public void setLastName(String lastName) {
		this.cost = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
