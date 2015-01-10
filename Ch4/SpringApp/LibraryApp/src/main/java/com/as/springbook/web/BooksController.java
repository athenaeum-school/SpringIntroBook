/*
 * All Rights Reserved by Athenaeum Society 2015-
 * Written by Inotakuya
 */
package com.as.springbook.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.as.springbook.domain.Book;
import com.as.springbook.repository.BookRepository;
import com.as.springbook.service.BookService;

@Controller
@RequestMapping("/as/books")
public class BooksController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookRepository bookRepository;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	public @ResponseBody Page<Book> getAllBooks(
			@RequestParam(value = "search", required = false, defaultValue = "") String search,
			@RequestParam(value = "page", required = false, defaultValue = "0") String page,
			@RequestParam(value = "size", required = false, defaultValue = "5") String size,
			@RequestParam(value = "sort", required = false, defaultValue = "") String sortStr) {
		return bookService.findAll(search, page, size, sortStr);
		
	}
}
