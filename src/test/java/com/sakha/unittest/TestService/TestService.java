package com.sakha.unittest.TestService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.sakha.mapper.user.UserMapper;
import com.sakha.unittest.dto.UserDTO;
import com.sakha.unittest.model.UserEntity;
import com.sakha.unittest.repository.UserRepository;
import com.sakha.unittest.service.impl.UserServiceImpl;

import junit.framework.Assert;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserMapper.class})
public class TestService {

	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserServiceImpl userService;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void TestGetUser() {
		
		Integer userId = 1;
		
		
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1);
		userEntity.setMobile("1234567890");
		userEntity.setName("priya");
		
		UserDTO userDto = new UserDTO();
		userDto.setId(1);
		userDto.setMobile("1234567890");
		userDto.setName("priya");
		

		PowerMockito.mockStatic(UserMapper.class);
        Mockito.when(UserMapper.entityToDto(userEntity)).thenReturn(userDto);
 
		Mockito.when(userRepository.findById(userId)).thenReturn(userEntity);	
		
		UserDTO user = userService.getUser(userId);
		
		Assert.assertEquals("priya", user.getName());
		Assert.assertEquals("1234567890", user.getMobile());
		Assert.assertEquals("1", String.valueOf(user.getId()));


	}
}
