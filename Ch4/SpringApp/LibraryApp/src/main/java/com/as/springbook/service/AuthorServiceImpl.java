/*
* All Rights Reserved by Athenaeum Society 2015-
* Written by Inotakuya
*/
package com.as.springbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.as.springbook.domain.Author;
import com.as.springbook.repository.AuthorRepository;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	@Override
	public Author findOne(long authorId) {
		return authorRepository.findOne(authorId);
	}

	@Override
	public Author create(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public Author update(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public void delete(long authorId) {
		authorRepository.delete(authorId);
	}

}
