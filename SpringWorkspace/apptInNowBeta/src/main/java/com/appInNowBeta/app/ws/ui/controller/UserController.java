package com.appInNowBeta.app.ws.ui.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;

import com.appInNowBeta.app.ws.io.entity.CalendarEntity;
import com.appInNowBeta.app.ws.service.UserService;
import com.appInNowBeta.app.ws.shared.dto.CalendarDto;
import com.appInNowBeta.app.ws.shared.dto.UserDto;
import com.appInNowBeta.app.ws.ui.model.request.CalendarDetailsRequestModel;
import com.appInNowBeta.app.ws.ui.model.request.UserDetailsRequestModel;

import com.appInNowBeta.app.ws.ui.model.response.CalendarInfo;
import com.appInNowBeta.app.ws.ui.model.response.UserInfo;




// security imports
//import com.appInNowBeta.app.ws.SpringApplicationContext;
//import com.appInNowBeta.app.ws.security.SecurityConstants;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Controller
//@RequestMapping("welcome")//http://localhost:8080/welcome


public class UserController {
	
	@Autowired
	UserService userService;
	
	//user flow 
	
	
	//welcome page to advertise to user
	@GetMapping("welcome")
	public String getWelcomePage()
	{
		
		return "welcome.html";
	}
	
	//HTML page to register new service provider
	
	@GetMapping("welcome/register")
	public String getUserSignUpForm()
	{
		
		return "registrationPage.html";
	}
	
	
	

	// HTML page for returning users to sign in
	@GetMapping("welcome/signin")
	public String getLoginForm()
	{
		
		return "signin.html";
	}
	
	
	
	@GetMapping("welcome/profile/{id}")
	public String greetingSubmit(@ModelAttribute UserInfo greeting) {
		
		return "profile.html";
	}
	

	
	
	
	

	// To return user info the the HTML page
	
	@GetMapping("welcome/logon/{id}")
	@ResponseBody
	public UserInfo getUser(@PathVariable String id){
		
		
		UserInfo returnValue = new UserInfo();
		
		UserDto userDto = userService.getUserByUserId(id);
		
		BeanUtils.copyProperties(userDto,returnValue);
		
		return returnValue;
	}
	
	@GetMapping("welcome/calendar/{id}")
	@ResponseBody
	public List<CalendarEntity> getCalendar(@PathVariable String id){
		
		
		
		List<CalendarEntity> Appointments = userService.findCalendarAppointmentsByUserId(id);
		
		
		
		return Appointments;
	}
	
	@GetMapping("welcome/appointment/{category}")
	@ResponseBody
	public CalendarInfo getAppointment(@PathVariable String category){
		
		
		CalendarInfo returnValue = new CalendarInfo();
		
		CalendarDto CalendarDto = userService.getCalendarByEmail(category);
		
		BeanUtils.copyProperties(CalendarDto,returnValue);
		
		return returnValue;
	}
	

	
	
	
	// Creating a new user in the database. 
	@PostMapping("welcome/users" )
	public UserInfo creatUser(@RequestBody UserDetailsRequestModel userDetails)
	{
		
		UserInfo returnValue = new UserInfo();
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser,  returnValue);
	
		return returnValue;
	}
	
	//creating a new appointment in the appointment table
	@PostMapping("welcome/calendar")
	@ResponseBody
	public CalendarInfo createCalendar(@RequestBody CalendarDetailsRequestModel calendarDetials)
	{
		
		CalendarInfo returnValue = new CalendarInfo();
		
		CalendarDto CalendarDto = new CalendarDto();
		BeanUtils.copyProperties(calendarDetials, CalendarDto);
		
		CalendarDto createdCalendar = userService.createCalendar(CalendarDto);
		BeanUtils.copyProperties(createdCalendar,  returnValue);
		
			
		return returnValue;
		
	}
	
	

	
	
}
