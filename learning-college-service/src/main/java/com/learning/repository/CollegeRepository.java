package com.learning.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.model.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long>{

	public List<College> findByCollegeActiveAndCollegeCityIn(String collegeActive, List<String> collegeCity);
	
	public Slice<College> findBy(Pageable pageable);
}
