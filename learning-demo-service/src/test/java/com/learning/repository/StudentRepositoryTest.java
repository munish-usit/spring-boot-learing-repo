package com.learning.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learning.model.Student;

@SpringBootTest
public class StudentRepositoryTest {

	@Autowired
	private CollegeRepository studentRepository;

	@Test
	public void saveStudent() {
		Student student = Student.builder()
				.emailId("rahul1@gmail.com")
				.firstName("Rahul1")
				.lastName("Sharma")
				//.guardianName("Nikhil")
				//.guardianEmail("nikhil@gmail.com")
				//.guardianMobile("9999999999")
				.build();

		studentRepository.save(student);
	}
	
	@Test
    public void printAllStudent() {
        List<Student> studentList =  studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }
}
