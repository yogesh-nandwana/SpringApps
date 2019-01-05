package com.na.todo.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.na.todo.model.User;
import com.na.todo.service.ILoginService;

@RestController
public class LoginController {
	private static final Logger logger = Logger.getLogger("LoginController"); 
	
	@Autowired
	private ILoginService loginService;


	@PostMapping("/login")
	private User login(@RequestBody User userLoginInfo){
		logger.info(String.format("Request:/login for userId:%s",userLoginInfo.getUserId()));
		return loginService.authenticate(userLoginInfo);
	}
}