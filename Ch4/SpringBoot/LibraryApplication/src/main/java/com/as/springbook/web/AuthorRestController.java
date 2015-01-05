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

import com.as.springbook.domain.Author;
import com.as.springbook.service.AuthorService;

@RestController
@RequestMapping("as/authors")
public class AuthorRestController {

	@Autowired
	private AuthorService authorService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Author> getAuthors() {
		return authorService.findAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Author getAuthor(@PathVariable long id) {
		return authorService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Author postAuthor(@RequestBody Author author) {
		System.out.println(author);
		return authorService.create(author);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Author putAuthor(@PathVariable long id, @RequestBody Author author) {
		author.setAuthorId(id);
		return authorService.update(author);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteAuthor(@PathVariable long id) {
		authorService.delete(id);
	}

}
