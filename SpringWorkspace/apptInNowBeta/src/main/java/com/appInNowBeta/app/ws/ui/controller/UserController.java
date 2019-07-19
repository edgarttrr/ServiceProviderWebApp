package com.appInNowBeta.app.ws.ui.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.appInNowBeta.app.ws.service.UserService;
import com.appInNowBeta.app.ws.shared.dto.UserDto;
import com.appInNowBeta.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appInNowBeta.app.ws.ui.model.response.User;


@Controller
//@RequestMapping("users")//http://localhost:8080/users




public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public String getForm()
	{
		
		return "users.html";
	}
	
	
	
	@GetMapping("/welcome")
	public String getWelcome()
	{
		
		return "welcome.html";
	}
	
	
	@PostMapping("/users")
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
