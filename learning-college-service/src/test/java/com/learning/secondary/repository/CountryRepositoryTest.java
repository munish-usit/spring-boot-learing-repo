package com.learning.secondary.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learning.secondary.model.Country;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class CountryRepositoryTest {

	@Autowired
	private CountryRepository countryRepository;

	
	@Test
    public void fetchCountryData() {
		List<Country> countryList = countryRepository.findAll();
        log.info("college count {} ", countryList.size());
        log.info("college data {}", countryList);
    }
}
