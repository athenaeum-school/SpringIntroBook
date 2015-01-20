/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.as.springbook.domain.Book;
import com.as.springbook.domain.common.AbstractHibernateRepository;
import com.as.springbook.repository.IBookRepository;

@Repository
public class BookRepository extends AbstractHibernateRepository<Book> implements IBookRepository {
		
    public BookRepository() {
        super();
        setClass(Book.class);
    }

 }