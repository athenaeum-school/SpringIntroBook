package com.as.springbook.service;

import java.util.List;

import com.as.springbook.domain.Author;

public interface AuthorService {

	List<Author> findAll();
	
	Author findOne(long authorId);
	
	Author create(Author author);
	
	Author update(Author author);
	
	void delete(long authorId);
}
