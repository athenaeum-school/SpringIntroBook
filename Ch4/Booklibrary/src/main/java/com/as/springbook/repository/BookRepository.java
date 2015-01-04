package com.as.springbook.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.as.springbook.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	Page<Book> findByTitleLike(String title,Pageable pageable);
}
