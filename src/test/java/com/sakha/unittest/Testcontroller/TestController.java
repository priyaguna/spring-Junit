package com.sakha.unittest.Testcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import com.sakha.unittest.controller.UserController;
import com.sakha.unittest.dto.UserDTO;
import com.sakha.unittest.service.UserService;

@RunWith(PowerMockRunner.class)
public class TestController {
	

	@InjectMocks
	private UserController userController = new UserController();
	
	
	@Mock
	private UserService userService;
	
	@Before
	public void setUp() {
		//Initialise the fields which are annotated with mockito annotations
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetUser() {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		Integer userId = 1;
		UserDTO userDto = new UserDTO();
		userDto.setId(1);
		userDto.setMobile("1234567890");
		userDto.setName("priya");

		Mockito.when(userController.getUser(request, response, userId)).thenReturn(userDto);
	}
}
