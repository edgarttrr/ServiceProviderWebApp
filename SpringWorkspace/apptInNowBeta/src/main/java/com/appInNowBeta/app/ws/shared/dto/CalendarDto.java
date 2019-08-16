package com.appInNowBeta.app.ws.shared.dto;

import java.io.Serializable;

public class CalendarDto implements Serializable {

	private static final long serialVersionUID = 6592879162083922404L;
	
	private String startTime;
	private String endTime;
	private String apptSlots;
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getApptSlots() {
		return apptSlots;
	}
	public void setApptSlots(String apptSlots) {
		this.apptSlots = apptSlots;
	}

	

	

}
