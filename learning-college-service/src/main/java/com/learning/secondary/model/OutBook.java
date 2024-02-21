package com.learning.secondary.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
		name = "out_books"
)
public class OutBook {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="out_books_seq_gen")
	@SequenceGenerator(name = "out_books_seq_gen", sequenceName = "out_books_seq", allocationSize = 1)
	@Column(name="book_id")
	private Long bookId;
	
	@Column(name="book_name")
	private String bookName;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id") 
	 @JsonIgnore
	private OutAuthor author;
	
}
