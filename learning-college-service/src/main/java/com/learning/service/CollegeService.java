package com.learning.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.model.College;
import com.learning.repository.CollegeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CollegeService {

	@Autowired
	private CollegeRepository collegeRepository;
	
	public College getCollege(Long collegeId) {
		log.info("getCollege id {}",collegeId);
		Optional<College> collegeOptional = collegeRepository.findById(collegeId);
		return collegeOptional.get();
	}
	
	public College addCollege(College college) {
		log.info("addCollege {}",college);
		College college2 = collegeRepository.save(college);
		return college2;
	}
}
