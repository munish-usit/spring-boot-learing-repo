package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.model.Student;
import com.learning.service.StudentService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student/{studentId}")
	public ResponseEntity<Student> getStudent(@PathVariable Long studentId) {
		Student student = studentService.geStudent(studentId);
		log.info("get user request");
		return ResponseEntity.ok(student);
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> addUser(@RequestBody Student student) {
		log.info("add user request {}",student);
		Student student2 = studentService.addStudent(student);
		return ResponseEntity.ok(student2);
	}
}
