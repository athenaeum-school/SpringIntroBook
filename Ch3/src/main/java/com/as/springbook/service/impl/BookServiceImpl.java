/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.springbook.domain.Book;
import com.as.springbook.domain.common.CommonActions;
import com.as.springbook.dto.BookDTO;
import com.as.springbook.repository.IBookRepository;
import com.as.springbook.service.BookService;
import com.as.springbook.service.common.AbstractApplicationComponent;

@Service
public class BookServiceImpl extends AbstractApplicationComponent<Book> implements BookService {

    @Autowired
    private IBookRepository bookRepository;

    public BookServiceImpl() {
        super();
    }

    @Override
    protected CommonActions<Book> getCommonRepository() {
        return bookRepository;
    }

    /*
	private BookDTO constructFormObject(Book book) {
        BookDTO formObject = new BookDTO();
        
        formObject.setId(book.getId());
        //formObject.setFirstName(book.getFirstName());
        //formObject.setLastName(book.getLastName());
        
        return formObject;
    }
    */
    
}

