package com.appInNowBeta.app.ws.ui.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.appInNowBeta.app.ws.security.AuthenticationFilter;
import com.appInNowBeta.app.ws.security.AuthorizationFilter;
import com.appInNowBeta.app.ws.security.SecurityConstants;
import com.appInNowBeta.app.ws.service.UserService;
import com.appInNowBeta.app.ws.shared.dto.CalendarDto;
import com.appInNowBeta.app.ws.shared.dto.UserDto;
import com.appInNowBeta.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appInNowBeta.app.ws.ui.model.response.AutherizationInfo;
import com.appInNowBeta.app.ws.ui.model.response.CalendarInfo;
import com.appInNowBeta.app.ws.ui.model.response.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Controller
//@RequestMapping("welcome")//http://localhost:8080/welcome


public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("welcome/users")
	public String getUserSignUpForm()
	{
		
		return "users.html";
	}
	
	@GetMapping("welcome/calendar")
	public String getcalendar()
	{
		
		return "calendar";
	}
	

	
	@GetMapping("welcome/service")
    public String greetingSubmit(@ModelAttribute UserInfo returnValue) {
		
		

		return "service";
        
    }
	
//	@PostMapping("welcome/signIn")
//	 protected AuthenticationFilter getAuthenticationFilter() throws Exception {
////    	if (HttpMethod.POST != null) {
////    		  
//    	final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
//	    filter.setFilterProcessesUrl("/welcome/signIn");
//	    return filter;
////    	}else {
////    		final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
////    	    filter.setFilterProcessesUrl("/welcome/nothing");
////    	    return filter;
////    	}
//    	
//    	
//	}
	
	


	@GetMapping("welcome/signIn")
	public String getLoginForm()
	{
		
		return "login";
	}
	
	@GetMapping("welcome/login")
	public String getLogin()
	{
		
		return "login";
	}
	

	
	
	@GetMapping("welcome/login/{id}")
	@ResponseBody
	public UserInfo getUser(@PathVariable String id){
		
		UserInfo returnValue = new UserInfo();
		
		UserDto userDto = userService.getUserByUserId(id);
		
		BeanUtils.copyProperties(userDto,returnValue);
		
		return returnValue;
	}
	

	
	@GetMapping("welcome")
	public String getWelcomePage()
	{
		
		return "welcome.html";
	}
	
	
	@PostMapping("welcome/users")
	public UserInfo creatUser(@RequestBody UserDetailsRequestModel userDetails)
	{
		System.out.println("asdad");
		UserInfo returnValue = new UserInfo();
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser,  returnValue);
		
			
		return returnValue;
		
	}
	
	@PostMapping("welcome/calendar")
	public CalendarInfo createCalendar(@RequestBody UserDetailsRequestModel calendarDetials)
	{
		System.out.println("asdad");
		CalendarInfo returnValue = new CalendarInfo();
		
		CalendarDto CalendarDto = new CalendarDto();
		BeanUtils.copyProperties(calendarDetials, CalendarDto);
		
		CalendarDto createdCalendar = userService.createCalendar(CalendarDto);
		BeanUtils.copyProperties(createdCalendar,  returnValue);
		
			
		return returnValue;
		
	}
	
	

	
	
}
