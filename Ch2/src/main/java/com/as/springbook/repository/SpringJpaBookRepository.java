/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.as.springbook.domain.Book;

/**
 * @author komatsu
 *
 */
public interface SpringJpaBookRepository extends CrudRepository<Book, Long> {

	public List<Book> findByFirstName(String firstName);	
	public List<Book> findByFirstNameAndLastName(String firstName, String lastName);
	public List<Book> findByTitleAndFirstNameAndLastName(String Title, String firstName, String lastName);
	
}
