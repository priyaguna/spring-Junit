package com.sakha.unittest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sakha.unittest.dto.ErrorDTO;
import com.sakha.unittest.dto.UserDTO;
import com.sakha.unittest.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final String GET_USER = "/user";

	@Autowired
	UserService userService;

	@RequestMapping(value = GET_USER, method = RequestMethod.GET)
	public UserDTO getUser(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("userId") Integer userId) {
		UserDTO userDto = null;
		try {
			userDto =  userService.getUser(userId);
		} catch (Exception e) {
			ErrorDTO errorJson = new ErrorDTO();
			errorJson.setErrorMessage(e.getMessage());
			//return new ResponseEntity<ErrorDTO>(errorJson, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return userDto;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDTO> exceptionHandeler(HttpServletRequest req, Exception exception) {

		ErrorDTO errorJson = new ErrorDTO();
		errorJson.setErrorMessage(exception.getMessage());

		return new ResponseEntity<ErrorDTO>(errorJson, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
