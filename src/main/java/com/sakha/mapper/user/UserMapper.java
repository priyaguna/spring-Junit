/**
 * 
 */
package com.sakha.mapper.user;

import org.modelmapper.ModelMapper;

import com.sakha.unittest.dto.UserDTO;
import com.sakha.unittest.model.UserEntity;


public class UserMapper {

	public static UserDTO entityToDto(UserEntity user) {
		ModelMapper modelMapper = new ModelMapper();

		UserDTO userDTO = modelMapper.map(user, UserDTO.class);

		return userDTO;
	}
}
