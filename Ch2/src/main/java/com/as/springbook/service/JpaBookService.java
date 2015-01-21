/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.service;

import java.util.List;

import com.as.springbook.domain.Book;

/**
 * @author komatsu
 *
 */
public interface JpaBookService {
	
	public List<Book> findAll();
	public Book findById(Long id);
	public Book save(Book book);
	public void delete(Book book);
	public List<Book> findAllByNativeQuery();
	public List<Book> findByCriteriaQuery(String firstName, String lastName);
	public List<Book> findByTitle(String firstName);
	public List<Book> findByTitleAndPublishedYear(String firstName, String lastName);	
}
