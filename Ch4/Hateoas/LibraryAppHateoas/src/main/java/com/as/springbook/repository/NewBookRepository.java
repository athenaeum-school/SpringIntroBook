/*
* All Rights Reserved by Athenaeum Society 2015-
* Written by Inotakuya
*/
package com.as.springbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.as.springbook.domain.Book;

@RepositoryRestResource(collectionResourceRel = "book",path = "book")
public interface NewBookRepository extends JpaRepository<Book, Long>{

}
