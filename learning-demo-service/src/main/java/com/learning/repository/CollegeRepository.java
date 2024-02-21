package com.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.model.Student;

@Repository
public interface CollegeRepository extends JpaRepository<Student, Long>{

}
