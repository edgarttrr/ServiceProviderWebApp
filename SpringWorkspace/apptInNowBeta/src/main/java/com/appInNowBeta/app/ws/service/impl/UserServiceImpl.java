package com.appInNowBeta.app.ws.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.appInNowBeta.app.ws.io.entity.CalendarEntity;
import com.appInNowBeta.app.ws.io.entity.UserEntity;
import com.appInNowBeta.app.ws.io.repositories.CalendarRepository;
import com.appInNowBeta.app.ws.io.repositories.UserRepository;
import com.appInNowBeta.app.ws.service.UserService;
import com.appInNowBeta.app.ws.shared.dto.CalendarDto;
import com.appInNowBeta.app.ws.shared.dto.UserDto;
import com.appInNowBeta.app.ws.shared.dto.Utils;




@Service
public class UserServiceImpl implements UserService {

	@Autowired
	CalendarRepository calendarRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Override
	public UserDto createUser(UserDto user) {
		
		
		if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("record already exists");
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		String publicUserId = utils.generateUserId(30);
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setUserId(publicUserId);
		
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		
		return returnValue;
	}
	
	@Override 
	public UserDto getUserByEmail(String email) {
		
		
		UserEntity userEntity = userRepository.findByEmail(email);
		
		if (userEntity == null)throw new UsernameNotFoundException(email);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(email);
		
		if (userEntity == null)throw new UsernameNotFoundException(email);
		
		
		return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(), new ArrayList<>());
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		UserDto returnValue = new UserDto();
		UserEntity userEntity = userRepository.findByUserId(userId);
		
		if (userEntity == null)throw new UsernameNotFoundException(userId);
		
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;
	}

	@Override
	public CalendarDto createCalendar(CalendarDto user) {
		
		
		
		CalendarEntity CalendarEntity = new CalendarEntity();
		BeanUtils.copyProperties(user, CalendarEntity);
		
				
		CalendarEntity storedUserDetails = calendarRepository.save(CalendarEntity);
		
		CalendarDto returnValue = new CalendarDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		
		return returnValue;
		
	}

	@Override
	public CalendarDto getCalendarByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalendarDto getCalendarByUserId(String userId) {
		CalendarDto returnValue = new CalendarDto();
		CalendarEntity CalendarEntity = calendarRepository.findCalendarByUserId(userId);
		
		if (CalendarEntity == null)throw new UsernameNotFoundException(userId);
		
		BeanUtils.copyProperties(CalendarEntity, returnValue);
		return returnValue;
	}

	@Override
	public List<CalendarEntity> findCalendarAppointmentsByUserId(String userId) {
		
		
		
		List<CalendarEntity> CalendarEntity = calendarRepository.findCalendarAppointmentsByUserId(userId);
		
		
		
		return CalendarEntity;
	}




}
