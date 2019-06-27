package com.test.app.aws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.aws.service.UserService;
import com.test.app.aws.shared.dto.UserDto;
import com.test.app.aws.ui.model.request.UserDetailsRequestModel;
import com.test.app.aws.ui.model.response.User;

@RestController
@RequestMapping("users")//http://localhost:8080/users
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser()
	{
		return "get user was called";
	}
	@PostMapping 
	public User creatUser(@RequestBody UserDetailsRequestModel userDetails)
	{
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
