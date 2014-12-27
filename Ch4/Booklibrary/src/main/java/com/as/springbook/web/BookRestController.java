package com.as.springbook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.as.springbook.domain.Book;
import com.as.springbook.service.BookService;

@RestController
@RequestMapping("as/books")
public class BookRestController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Book> getBooks(){
		return bookService.findAll();
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public Book getBook(@PathVariable long id){
		return bookService.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Book postBook(@RequestBody Book book){
		return bookService.create(book);
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.PUT)
	public Book putBook(@PathVariable long id, @RequestBody Book book){
		book.setBookId(id);
		return bookService.update(book);
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public void deleteBook(@PathVariable long id){
		bookService.delete(id);
	}
	
}
