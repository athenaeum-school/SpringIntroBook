/*
* All Rights Reserved by Athenaeum Society 2015-
* Written by Inotakuya
*/
package com.as.springbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.as.springbook.domain.Author;
import com.as.springbook.domain.Book;
import com.as.springbook.repository.AuthorRepository;
import com.as.springbook.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

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
	public Book create(Book book, long authorId) {
		book.getAuthors().add(authorRepository.findOne(authorId));
		Author author = authorRepository.findOne(authorId);
		
		author.getBooks().add(book);
		authorRepository.save(author);
		return book;
	}

	@Override
	public Book update(Book book,long bookId,long authorId) {
		if(book == null){
			Book existBook = bookRepository.findOne(bookId);
			existBook.getAuthors().add(authorRepository.findOne(authorId));
			return bookRepository.save(existBook);
		}
		book.setBookId(bookId);
		book.setAuthors(bookRepository.findOne(bookId).getAuthors());
		
		return bookRepository.save(book);
	}

	@Override
	public void delete(long bookId) {
		bookRepository.delete(bookId);
	}

	@Override
	public Page<Book> findAll(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}

	@Override
	public Page<Book> findAll(String search, String page, String size,
			String sortStr) {
		Sort sort;
		String title = "title";
		if (sortStr.equals("asc"))
			sort = new Sort(Direction.ASC, title);
		else if (sortStr.equals("desc"))
			sort = new Sort(Direction.DESC, title);
		else
			sort = null;
		return bookRepository.findByTitleOrAuthorFirstNameOrAuthorLastName(search, 
				new PageRequest(Integer.valueOf(page), Integer.valueOf(size),
						sort));

	}

}
