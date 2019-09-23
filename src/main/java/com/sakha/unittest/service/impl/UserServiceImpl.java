package com.sakha.unittest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakha.unittest.controller.UserEntity;
import com.sakha.unittest.dto.UserDTO;
import com.sakha.unittest.repository.UserRepository;
import com.sakha.unittest.service.UserService;

@Service
public class UserServiceImpl implements UserService {

//	@Autowired
//	ModelMapper modelMapper;

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDTO getUser(Integer userId) {

		UserEntity userEntity = userRepository.findById(userId);

		UserDTO userDTO = new UserDTO();
		//modelMapper.map(userEntity, UserDTO.class);

		userDTO.setId(1);
		userDTO.setName("bhavana");
		return userDTO;
	}

}
