package com.learning.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.learning.model.Author;
import com.learning.repository.AuthorRepository;
import com.learning.secondary.model.OutAuthor;
import com.learning.secondary.model.OutBook;
import com.learning.secondary.repository.OutAuthorRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class ServiceTest {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private OutAuthorRepository outAuthorRepository;
	
	@Test
	public void fetchAuthor() {
		List<Author> authorList = authorRepository.findAll();
		log.info("author data size {}",authorList.size());
		log.info("author list data {}",authorList);
		
	}
	
	@Test
	@Transactional(readOnly = true)
	public void fetchAndInsertAuthor() {
		List<Author> authorList = authorRepository.findAll();
		log.info("author list size {}",authorList.size());
		
		List<OutAuthor> outAuthorList = new ArrayList<>();
		for(Author authorObject : authorList) {

			OutAuthor outAuthor = OutAuthor.builder()
					//.authorId(author.getAuthorId())
					.authorName(authorObject.getAuthorName())
					.build();
			
			List<OutBook> outBooks = authorObject.getBooks().stream()
					.map(book -> OutBook.builder()
							//.bookId(book.getBookId())
							.bookName(book.getBookName())
							.author(outAuthor)
							//.authorId(book.getAuthorId())
							.build())
					.collect(Collectors.toList());

			outAuthor.setBooks(outBooks);
			
			outAuthorList.add(outAuthor);
			
			log.info("out-author data  {}",outAuthor);
		}


		outAuthorRepository.saveAll(outAuthorList);
		
		
	}
	
	
}
