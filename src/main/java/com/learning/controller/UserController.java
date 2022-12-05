package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.model.User;
import com.learning.service.UserService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<User> getUser() {
		User user = userService.getUsers();
		log.info("get user request");
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		log.info("add user request {}",user);
		User user2 = userService.addUser(user);
		return ResponseEntity.ok(user2);
	}
}
