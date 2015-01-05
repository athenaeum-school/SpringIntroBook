/*
* All Rights Reserved by Athenaeum Society 2015-
* Written by Inotakuya
*/
package com.as.springbook.hateoas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.as.springbook.domain.NewBook;

@RepositoryRestResource(collectionResourceRel = "newBook",path = "newBook")
public interface NewBookRepository extends JpaRepository<NewBook, Long>{

}
