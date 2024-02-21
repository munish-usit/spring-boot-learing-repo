package com.learning.secondary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.secondary.model.OutAuthor;

@Repository
public interface OutAuthorRepository extends JpaRepository<OutAuthor, Long>{

}
