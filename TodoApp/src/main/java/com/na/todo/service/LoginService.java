package com.na.todo.service;

import java.util.Arrays;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.na.todo.model.User;
import com.na.todo.repository.UserRepository;

@Service
public class LoginService implements ILoginService {
	private static final Logger logger = Logger.getLogger("LoginService"); 

	@Autowired
	private UserRepository userRepo;

	@Override
	public User authenticate(User user) {
		User foundUser = userRepo.findByUserId(user.getUserId());
		if(foundUser!=null && Arrays.equals(foundUser.getPassword(),user.getPassword())){
			logger.info(String.format("userId:%s matched in database.",user.getUserId()));
			return foundUser;
		}
		logger.info(String.format("userId:%s could not be matched in database.",user.getUserId()));
		return null;
	}
}