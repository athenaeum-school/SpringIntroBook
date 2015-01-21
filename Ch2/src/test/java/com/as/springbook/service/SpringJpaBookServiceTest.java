/**
 * 
 */
package com.as.springbook.service;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.as.springbook.config.JpaConfig;
import com.as.springbook.domain.Book;

/**
 * @author komatsu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class SpringJpaBookServiceTest {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	SpringJpaBookService bookService;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateBook() {
		Book book = new Book();
		book.setTitle("MyTitle0");
		bookService.save(book);
	}
	
}
