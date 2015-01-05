/*
* All Rights Reserved by Athenaeum Society 2015-
* Written by Inotakuya
*/
package com.as.springbook.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.as.springbook.domain.Book;
import com.as.springbook.service.BookService;

@RestController
@RequestMapping("/as/books")
public class BooksRestController {

	@Autowired
	private BookService bookService;

	@RequestMapping(method = RequestMethod.GET)
	public Page<Book> getAllBooks(
			@RequestParam(value = "search", required=false,defaultValue="") String search,
			@RequestParam(value = "page", required = false, defaultValue = "0") String page,
			@RequestParam(value = "size", required = false, defaultValue = "5") String size,
			@RequestParam(value = "sort", required = false, defaultValue = "") String sortStr,
			Sort sort) {
		return bookService.findAll(search,page, size, sortStr);
	}
}
