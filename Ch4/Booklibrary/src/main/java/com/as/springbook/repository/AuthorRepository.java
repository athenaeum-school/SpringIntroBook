package com.as.springbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.as.springbook.domain.Author;

@RepositoryRestResource(collectionResourceRel = "author", path = "author")
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
