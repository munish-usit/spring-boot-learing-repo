package com.learning.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(
		name = "college"
)
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long collegeId;
	private String collegeName;
	private String collegeAddress;
	private String collegeEmailId;
	
}
