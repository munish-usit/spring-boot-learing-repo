package com.learning.secondary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.secondary.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

}
