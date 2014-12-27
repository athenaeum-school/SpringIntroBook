package com.as.springbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.as.springbook.domain.Author;
import com.as.springbook.domain.Book;
import com.as.springbook.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book findOne(long bookId) {
		return bookRepository.findOne(bookId);
	}

	@Override
	public Book create(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book update(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void delete(long bookId) {
		bookRepository.delete(bookId);
	}

}
