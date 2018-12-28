package com.na.todo.service;

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
		if(foundUser!=null && foundUser.getPassword().equals(user.getPassword())){
			logger.info("userId:"+user.getUserId() +" matched in database.");
			return foundUser;
		}
		logger.info("userId:"+user.getUserId() +" could not be matched in database.");
		return null;
	}
}