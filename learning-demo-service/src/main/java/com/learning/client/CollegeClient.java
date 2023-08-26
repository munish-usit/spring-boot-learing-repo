package com.learning.client;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.model.College;

import lombok.extern.slf4j.Slf4j;


@FeignClient(name = "learning-college-service")
public interface CollegeClient {

	@GetMapping("/college/{collegeId}")
	public College getCollege(@PathVariable Long collegeId) ;
	
}

@Component
class CollegeFallbackFactory implements FallbackFactory<CollegeClient> {
	@Override
	public CollegeClient create(Throwable cause) {
		return new CollegeServiceFallback(cause);
	}
}

@Slf4j
class CollegeServiceFallback implements CollegeClient {


	private final Throwable cause;
	
	public CollegeServiceFallback(Throwable cause2) {
		this.cause = cause2;
	}

	@Override
	public College getCollege(Long collegeId) {
		log.error("error in colelge api",cause);
		return new College();
	}
	
}
