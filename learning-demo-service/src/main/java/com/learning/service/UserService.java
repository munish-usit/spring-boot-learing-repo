package com.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.learning.model.User;
import com.learning.utils.ApplicationUtility;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Value("${user-create}")
	private boolean userCreate = false;
	
	@Value("${user-error-message}")
	private String errorMessage;
	
	@Autowired
	private ApplicationUtility utility;
	
	public User getUsers() {
		log.info("getUsers {}");
		User user = new User("1", "Deepak");
		return user;
	}
	
	public User addUser(User user) {
		if(!userCreate) {
			log.info("error {}",errorMessage);
			return null;
		}
		log.info("addUser {}",user);
		log.info("unique-id {}",utility.generateId());
		return user;
	}
}
