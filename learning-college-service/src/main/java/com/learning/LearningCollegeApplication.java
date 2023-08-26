package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LearningCollegeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningCollegeApplication.class, args);
	}

}
