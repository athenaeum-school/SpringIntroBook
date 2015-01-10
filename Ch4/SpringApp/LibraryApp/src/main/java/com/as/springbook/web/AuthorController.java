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

import com.as.springbook.domain.Author;
import com.as.springbook.service.AuthorService;

@Controller
@RequestMapping("as/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=utf-8")
	public @ResponseBody List<Author> getAuthors() {
		return authorService.findAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=utf-8")
	public @ResponseBody Author getAuthor(@PathVariable long id) {
		return authorService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=utf-8")
	public @ResponseBody Author postAuthor(@RequestBody Author author) {
		System.out.println(author);
		return authorService.create(author);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=utf-8")
	public @ResponseBody Author putAuthor(@PathVariable long id,
			@RequestBody Author author) {
		author.setAuthorId(id);
		return authorService.update(author);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteAuthor(@PathVariable long id) {
		authorService.delete(id);
	}

}
