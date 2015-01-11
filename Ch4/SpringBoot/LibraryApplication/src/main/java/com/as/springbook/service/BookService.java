/*
 * All Rights Reserved by Athenaeum Society 2015-
 * Written by Inotakuya
 */
package com.as.springbook.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.as.springbook.domain.Book;

public interface BookService {

	List<Book> findAll();

	Book findOne(long bookId);

	Book create(Book book);

	Book create(Book book, long authorId);

	Book update(Book book, long bookId, long authorId);

	void delete(long id);

	Page<Book> findAll(Pageable pageable);

	Page<Book> findAll(String search, String page, String size, String sortStr);
}
