package com.learning.repository;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.learning.model.College;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest
@Slf4j
public class CollegeRepositoryTest {

	@Autowired
	private CollegeRepository collegeRepository;

	@Test
	public void saveStudent() {
		College college = College.builder()
				.build();

		collegeRepository.save(college);
	}
	
	@Test
    public void fetchCollegeData() {
        List<College> collegeList =  collegeRepository.findAll();
        collegeList = collegeRepository.findByCollegeActiveAndCollegeCityIn("Y", Arrays.asList("Delhi","Noida"));
        log.info("college count {} ", collegeList.size());
        log.info("college data {}", collegeList);
    }
	
	@Test
    public void fetchCollegeDataPageable() {
		Pageable pageRequest = PageRequest.of(0, 2);
        Page<College> collegePageResult =  collegeRepository.findAll(pageRequest);
        log.info("college data {}", collegePageResult.getContent());
        log.info("college slice {}, elements {} size {}",collegePageResult.getNumber(),collegePageResult.getNumberOfElements(),collegePageResult.getSize());
        log.info("college total pages {}, total elements {}",collegePageResult.getTotalPages(),collegePageResult.getTotalElements());
	}
	
	@Test
    public void fetchCollegeDataSlice() {
		int i = 0;
		Pageable pageRequest = PageRequest.of(i, 3);
        Slice<College> collegePageResult =  collegeRepository.findBy(pageRequest);
        log.info("college data {}", collegePageResult.getContent());
        log.info("college slice {}, elements {} size {}",collegePageResult.getNumber(),collegePageResult.getNumberOfElements(),collegePageResult.getSize());
        while(collegePageResult.hasNext()) {
        	i++;
        	pageRequest = PageRequest.of(i, 3);
        	collegePageResult =  collegeRepository.findBy(pageRequest);
            log.info("college data {}", collegePageResult.getContent());
            log.info("college slice {}, elements {} size {}",collegePageResult.getNumber(),collegePageResult.getNumberOfElements(),collegePageResult.getSize());
        }
	}
	
}
