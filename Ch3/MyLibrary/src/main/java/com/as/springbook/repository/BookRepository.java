/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.repository;

import org.springframework.stereotype.Repository;

import com.as.springbook.domain.BookImpl;
import com.as.springbook.domain.common.AbstractHibernateRepository;

@Repository
public class BookRepository extends AbstractHibernateRepository<BookImpl> implements IBookRepository {
	
    public BookRepository() {
        super();
        setClass(BookImpl.class);
    }

}