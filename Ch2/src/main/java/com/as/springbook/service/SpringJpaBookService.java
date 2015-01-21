/**
 * 
 */
package com.as.springbook.service;

import com.as.springbook.domain.Book;

/**
 * @author komatsu
 *
 */
public interface SpringJpaBookService {
	public void save(Book book);
	public void delete(Book book);
}
