package com.as.springbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.as.springbook.domain.Book;

@RepositoryRestResource(collectionResourceRel = "book", path = "book")
public interface BookRepository extends JpaRepository<Book, Long> {

}
