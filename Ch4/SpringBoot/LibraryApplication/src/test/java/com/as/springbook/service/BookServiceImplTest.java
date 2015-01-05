package com.as.springbook.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.as.springbook.LibraryApp;
import com.as.springbook.domain.Author;
import com.as.springbook.domain.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=LibraryApp.class)
@Transactional
/*@TransactionConfiguration(defaultRollback=false)*/
public class BookServiceImplTest {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;

	@Test
	public void testFindAll() {
	}

	@Test
	public void testFindOne() {
		System.out.println(authorService.findAll());
		System.out.println(bookService.findAll());
		System.out.println(authorService.findOne(1));
	}
	
	

	@Test
	public void testBookCreate() {
	/*	Author author = new Author();
		author.setAuthorId(1);
		author.setFirstName("abc");
		author.setLastName("xyz");
		authorService.create(author);
		
		Book book = new Book();
		book.setBookId(1);
		book.setPrice(1000);
		book.setTitle("初めてのspring");
		book.setAuthor(authorService.findOne(1));
		bookService.create(book);
		System.out.println(authorService.findAll());
		System.out.println(bookService.findAll());
		System.out.println("---");
		Author author2 = new Author();
		author2.setBooks(bookService.findAll());
		authorService.create(author2);
		
		System.out.println(authorService.findOne(2).getBooks());
		*/
	}

	@Test
	public void testBookUpdate() {
	}

	@Test
	public void testBookDelete() {
	}

}
