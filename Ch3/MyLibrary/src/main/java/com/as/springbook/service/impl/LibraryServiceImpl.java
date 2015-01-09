/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.as.springbook.domain.ClientImpl;
import com.as.springbook.domain.LibraryImpl;
import com.as.springbook.domain.common.CommonActions;
import com.as.springbook.repository.IClientRepository;
import com.as.springbook.repository.ILibraryRepository;
import com.as.springbook.service.ClientService;
import com.as.springbook.service.LibraryService;
import com.as.springbook.service.common.AbstractApplicationComponent;

/**
 * @author komatsu
 *
 */
public class LibraryServiceImpl extends AbstractApplicationComponent<LibraryImpl> implements LibraryService {

    @Autowired
    private ILibraryRepository libraryRepository;

    public LibraryServiceImpl() {
        super();
    }

    @Override
    protected CommonActions<LibraryImpl> getCommonRepository() {
        return libraryRepository;
    }
}
