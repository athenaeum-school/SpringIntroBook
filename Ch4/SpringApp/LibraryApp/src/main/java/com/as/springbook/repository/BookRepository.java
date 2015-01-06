/*
* All Rights Reserved by Athenaeum Society 2015-
* Written by Inotakuya
*/
package com.as.springbook.repository;

import java.util.HashSet;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.as.springbook.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	
	Page<Book> findByTitleContaining(String title,Pageable pageable);
	
	Page<Book> findDistinctByTitleContainingOrAuthorsFirstNameContaining(String search1,String search2,Pageable pageable);
	
	
	
}
