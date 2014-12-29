package com.as.springbook.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.as.springbook.domain.NewBook;
import com.as.springbook.repository.NewBookRepository;
import com.as.springbook.repository.PersonRepository;

@RestController
@RequestMapping("person/{id}/newBook")
public class NewBookRestController {

	@Autowired
	private NewBookRepository newBookRepository;

	@Autowired
	private PersonRepository personRepository;

	@RequestMapping(method = RequestMethod.POST)
	public NewBook createNewBook(@PathVariable long id,
			@RequestBody NewBook newBook) {
		newBook.setPerson(personRepository.findOne(id));
		return newBookRepository.save(newBook);
	}
}
