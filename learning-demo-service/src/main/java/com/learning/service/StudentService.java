package com.learning.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.client.CollegeClient;
import com.learning.model.College;
import com.learning.model.Student;
import com.learning.repository.CollegeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentService {

	@Autowired
	private CollegeRepository studentRepository;
	
	@Autowired
	private CollegeClient collegeClient;
	
	public Student geStudent(Long studentId) {
		log.info("getStudent id {}",studentId);
		Optional<Student> studentOptional = studentRepository.findById(studentId);
		Student student = studentOptional.get();
		Long collegeId = student.getCollegeId();
		
		// based on college id , college info
		College college = collegeClient.getCollege(collegeId);
		log.info("college id {}",college);
		return student;
	}
	
	public Student addStudent(Student student) {
		log.info("addStudent {}",student);
		Student student2 = studentRepository.save(student);
		return student2;
	}
}
