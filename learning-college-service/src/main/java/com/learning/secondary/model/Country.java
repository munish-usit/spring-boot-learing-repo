package com.learning.secondary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
		name = "tbl_country"
)
public class Country {

	@Id
	private Integer id;
	@Column(name="country_name")
	private String countryName;
	//@Column(name="iso_country_code_num")
	//private String isoCountryCodeNum;
}
