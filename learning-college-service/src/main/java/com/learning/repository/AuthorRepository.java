package com.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
