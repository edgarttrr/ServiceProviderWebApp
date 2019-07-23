package com.appInNowBeta.app.ws.ui.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.appInNowBeta.app.ws.service.UserService;
import com.appInNowBeta.app.ws.shared.dto.UserDto;
import com.appInNowBeta.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appInNowBeta.app.ws.ui.model.response.User;


@RestController
@RequestMapping("welcome")//http://localhost:8080/welcome




public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(path ="/users")
	public String getUserSignUpForm()
	{
		
		return "users.html";
	}
	
	@GetMapping(path="/login")
	public String getLoginForm()
	{
		
		return "login.html";
	}
	
	@GetMapping(path ="/login/{id}")
	public User getUser(@PathVariable String id){
		
		User returnValue = new User();
		try {
		UserDto userDto = userService.getUserByUserId(id);
		
		BeanUtils.copyProperties(userDto,returnValue);}
		catch(Exception e) {
			System.out.print("error here");
		}
		return returnValue;
	}
	
	
	
	
	
	@GetMapping()
	public String getWelcomePage()
	{
		
		return "welcome.html";
	}
	
	
	@PostMapping(path ="/users")
	public User creatUser(@RequestBody UserDetailsRequestModel userDetails)
	{
		System.out.println("asdad");
		User returnValue = new User();
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser,  returnValue);
		
			
		return returnValue;
		
	}
	
	
	@PutMapping
	public String updateUser()
	{
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser()
	{
		return "delete user was called";
	}
	
	
}
