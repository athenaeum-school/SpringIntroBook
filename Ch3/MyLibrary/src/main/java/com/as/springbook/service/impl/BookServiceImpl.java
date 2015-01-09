/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.springbook.domain.BookImpl;
import com.as.springbook.domain.common.CommonActions;
import com.as.springbook.repository.IBookRepository;
import com.as.springbook.service.BookService;
import com.as.springbook.service.common.AbstractApplicationComponent;

@Service
public class BookServiceImpl extends AbstractApplicationComponent<BookImpl> implements BookService {

    @Autowired
    private IBookRepository bookRepository;

    public BookServiceImpl() {
        super();
    }

    @Override
    protected CommonActions<BookImpl> getCommonRepository() {
        return bookRepository;
    }

}

