package com.as.springbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.as.springbook.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}