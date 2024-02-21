package com.learning.model;

import javax.persistence.Column;
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
	@Column(name="college_id")
	private Long collegeId;
	@Column(name="college_name")
	private String collegeName;
	@Column(name="college_address")
	private String collegeAddress;
	@Column(name="college_email_id")
	private String collegeEmailId;
	@Column(name="college_city")
	private String collegeCity;
	@Column(name="college_active")
	private String collegeActive;
	
}
