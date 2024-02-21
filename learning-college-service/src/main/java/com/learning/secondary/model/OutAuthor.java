package com.learning.secondary.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
		name = "out_authors"
)
public class OutAuthor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="out_authors_seq_gen")
	@SequenceGenerator(name = "out_authors_seq_gen", sequenceName = "out_authors_seq", allocationSize = 1)
	@Column(name="author_id")
	private Long authorId;
	
	@Column(name="author_name")
	private String authorName;
	
	/**
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id")
	List<OutBook> books;
	**/
	
	//@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy= "author")
	List<OutBook> books;
	
}
