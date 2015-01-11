/*
* All Rights Reserved by Athenaeum Society 2015-
* Written by Inotakuya
*/
package com.as.springbook.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.as.springbook.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByTitle(String title);

	Page<Book> findByTitleLike(String title,Pageable pageable);
	
	@Query("select distinct b from Book b left outer join b.authors a "
			+ "where b.title like %:search% or a.firstName like %:search% "
			+ "or a.lastName like %:search%")
	Page<Book> findByTitleOrAuthorFirstNameOrAuthorLastName(@Param("search") String search,
			Pageable pageable);
}
