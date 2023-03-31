package com.learning.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class College {

	private Long collegeId;
	private String collegeName;
	private String collegeAddress;
	private String collegeEmailId;
	
}
