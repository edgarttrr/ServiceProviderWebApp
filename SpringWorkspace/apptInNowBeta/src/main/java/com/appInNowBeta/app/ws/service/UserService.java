package com.appInNowBeta.app.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.appInNowBeta.app.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService{

	UserDto createUser(UserDto user);

}
