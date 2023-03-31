package com.learning.utils;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class ApplicationUtility {

	public String generateId() {
		return UUID.randomUUID().toString();
	}
}
