package com.appInNowBeta.app.ws.service;

import java.util.List;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.appInNowBeta.app.ws.io.entity.CalendarEntity;
import com.appInNowBeta.app.ws.shared.dto.CalendarDto;
import com.appInNowBeta.app.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService{

	UserDto createUser(UserDto user);
	CalendarDto createCalendar(CalendarDto user);
	UserDto getUserByEmail(String email);
	UserDto getUserByUserId(String userId);
	
	CalendarDto getCalendarByEmail(String email);
	CalendarDto getCalendarByUserId(String userId);

	
	List<CalendarEntity> findCalendarAppointmentsByUserId(String userId);

}
