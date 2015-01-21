/**
 * 
 */
package com.as.springbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.as.springbook.domain.Book;
import com.as.springbook.repository.SpringJpaBookRepository;
import com.as.springbook.service.SpringJpaBookService;

/**
 * @author komatsu
 *
 */
@Service
@Repository
@Transactional
public class SpringJpaBookServiceImpl implements SpringJpaBookService {

	@Autowired
	private SpringJpaBookRepository repository;

	public void save(Book book) {
		repository.save(book);
	}

	public void delete(Book book) {
		repository.delete(book);
	}

}
