package com.as.springbook.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.as.springbook.BooklibraryApplication;
import com.as.springbook.domain.Author;
import com.as.springbook.domain.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=BooklibraryApplication.class)
public class BookServiceImplTest {
	
	@Autowired
	private BookService bookService;

	@Test
	public void testFindAll() {
	}

	@Test
	public void testFindOne() {
	}

	@Test
	public void testBookCreate() {
		Author author = new Author();
		author.setFirstName("abc");
		author.setLastName("xyz");
		Book book = new Book();
		book.setBookId(1);
		book.setPrice(1000);
		book.setTitle("初めてのspring");
		book.setAuthor(author);
		bookService.create(book);
		System.out.println(bookService.findAll());
		
	}

	@Test
	public void testBookUpdate() {
	}

	@Test
	public void testBookDelete() {
	}

}
