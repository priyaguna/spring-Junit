/**
 * 
 */
package com.sakha.mapper.user;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.sakha.model.UserEntity;
import com.sakha.unittest.dto.UserDTO;


public class UserMapper {

	public static UserDTO entityToDto(UserEntity user) {
		ModelMapper modelMapper = new ModelMapper();

		UserDTO userDTO = modelMapper.map(user, UserDTO.class);

		return userDTO;
	}

	public static List<UserDTO> entityToDTOList(List<UserEntity> users) {
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		for (UserEntity user : users) {
			userDTOList.add(entityToDto(user));
		}
		return userDTOList;
	}
}
