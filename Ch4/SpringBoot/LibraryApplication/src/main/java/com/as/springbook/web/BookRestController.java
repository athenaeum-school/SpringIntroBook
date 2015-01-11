/*
 * All Rights Reserved by Athenaeum Society 2015-
 * Written by Inotakuya
 */
package com.as.springbook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.as.springbook.domain.Book;
import com.as.springbook.service.AuthorService;
import com.as.springbook.service.BookService;

@RestController
@RequestMapping("as/authors/{authorId}/books")
public class BookRestController {

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Book> getBooks(@PathVariable long authorId) {
		return authorService.findOne(authorId).getBooks();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Book getBook(@PathVariable long id, @PathVariable long authorId) {
		return bookService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Book postBook(@RequestBody Book book, @PathVariable long authorId) {
		/*
		 * book.setAuthor(authorService.findOne(authorId));
		 * 
		 * return bookService.create(book);
		 */
		/* book.getAuthors().add(authorService.findOne(authorId)); */

		return bookService.create(book, authorId);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Book putBook(@PathVariable long id, @PathVariable long authorId,
			@RequestBody Book book) {
		return bookService.update(book, id, authorId);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable long id) {
		bookService.delete(id);
	}

}
