/*
 * All Rights Reserved by Athenaeum Society 2015-
 * Written by Inotakuya
 */
package com.as.springbook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.as.springbook.domain.Book;
import com.as.springbook.service.AuthorService;
import com.as.springbook.service.BookService;

@Controller
@RequestMapping("as/authors/{authorId}/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=utf-8")
	public @ResponseBody List<Book> getBooks(@PathVariable long authorId) {
		return authorService.findOne(authorId).getBooks();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=utf-8")
	public @ResponseBody Book getBook(@PathVariable long id,
			@PathVariable long authorId) {
		return bookService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=utf-8")
	public @ResponseBody Book postBook(@RequestBody Book book,
			@PathVariable long authorId) {
		/*
		 * book.setAuthor(authorService.findOne(authorId));
		 * 
		 * return bookService.create(book);
		 */
		/* book.getAuthors().add(authorService.findOne(authorId)); */

		return bookService.create(book, authorId);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=utf-8")
	public @ResponseBody Book putBook(@PathVariable long id,
			@RequestBody Book book) {
		book.setBookId(id);
		return bookService.update(book);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable long id) {
		bookService.delete(id);
	}

}
