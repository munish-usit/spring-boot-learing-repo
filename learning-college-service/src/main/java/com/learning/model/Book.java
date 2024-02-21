package com.learning.model;

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
		name = "books"
)
public class Book {

	@Id
	@Column(name="book_id")
	private Long bookId;
	
	@Column(name="book_name")
	private String bookName;
	
	@Column(name="author_id")
	private Long authorId;
	
}
