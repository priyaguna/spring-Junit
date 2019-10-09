package com.sakha.mapper.Testuser;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import com.sakha.mapper.user.UserMapper;
import com.sakha.unittest.dto.UserDTO;
import com.sakha.unittest.model.UserEntity;

import junit.framework.Assert;

@RunWith(PowerMockRunner.class)
public class TestUserMapper {
	
	@InjectMocks
	UserMapper userMapper;
	
	@Before
	public void setUp() {
		//Initialise the fields which are annotated with mockito annotations
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testEntityToDto() {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1);
		userEntity.setMobile("1234567890");
		userEntity.setName("priya");
		
		UserDTO userDto = new UserDTO();
		userDto.setId(1);
		userDto.setMobile("1234567890");
		userDto.setName("priya");
		
		Mockito.mock(UserMapper.class);
		Assert.assertEquals(userDto.toString(), userMapper.entityToDto(userEntity).toString());
	}
}
