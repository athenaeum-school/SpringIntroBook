package com.as.springbook.service;

import java.util.List;

import com.as.springbook.domain.Author;
import com.as.springbook.domain.Book;

public interface BookService {

	List<Book> findAll();
	
	Book findOne(long bookId);
	
	Book create(Book book);
	
	Book update(Book book);
	
	void delete(long id);
}
