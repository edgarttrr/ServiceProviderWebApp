package com.appInNowBeta.app.ws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appInNowBeta.app.ws.UserRepository;
import com.appInNowBeta.app.ws.io.entity.UserEntity;
import com.appInNowBeta.app.ws.service.UserService;
import com.appInNowBeta.app.ws.shared.dto.UserDto;
import com.appInNowBeta.app.ws.shared.dto.Utils;




@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;
	
	@Override
	public UserDto createUser(UserDto user) {
		
		
		if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("record already exists");
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		String publicUserId = utils.generateUserId(30);
		userEntity.setEncryptedPassword(publicUserId);
		userEntity.setUserId(publicUserId);
		
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		
		return returnValue;
	}

}
