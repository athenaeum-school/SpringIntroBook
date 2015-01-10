/*
* All Rights Reserved by Athenaeum Society 2015-
* Written by Inotakuya
*/
package com.as.springbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.as.springbook.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	Author findByFirstName(String firstName);
}
