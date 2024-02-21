package com.learning.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
		name = "authors"
)
public class Author {

	@Id
	@Column(name="author_id")
	private Long authorId;
	
	@Column(name="author_name")
	private String authorName;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id")
	List<Book> books;
	
}
