/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.repository.impl;

import org.springframework.stereotype.Repository;

import com.as.springbook.domain.Library;
import com.as.springbook.domain.common.AbstractHibernateRepository;
import com.as.springbook.repository.ILibraryRepository;

@Repository
public class LibraryRepository extends AbstractHibernateRepository<Library> implements ILibraryRepository  {

    public LibraryRepository() {
        super();
        setClass(Library.class);
    }
	
}
