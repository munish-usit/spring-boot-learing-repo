package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.model.College;
import com.learning.service.CollegeService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class CollegeController {

	@Autowired
	private CollegeService collegeService;
	
	@GetMapping("/college/{collegeId}")
	public ResponseEntity<College> getCollege(@PathVariable Long collegeId) {
		College college = collegeService.getCollege(collegeId);
		log.info("get user request");
		return ResponseEntity.ok(college);
	}
	
	@PostMapping("/college")
	public ResponseEntity<College> addCollege(@RequestBody College college) {
		log.info("add user request {}",college);
		College college2 = collegeService.addCollege(college);
		return ResponseEntity.ok(college2);
	}
	
}
