package com.as.springbook.service;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.as.springbook.config.AbstractTestContext;
import com.as.springbook.config.JpaConfig;
import com.as.springbook.domain.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class BookServiceTest {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	JpaBookService bookService;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Book book = new Book();
		book.setTitle("MyTitle0");
		bookService.save(book);		
	}
	
	@Test
	@Transactional
	public void testBookAudit() {
		Book book = new Book();
		book.setTitle("MYLibrary007");
		bookService.save(book);
		em.flush();
	
		assertTrue(null != book.getId());
		assertTrue(book.getCreatedBy() != null);
		assertTrue(book.getCreatedDate() != null);
		//assertTrue(book.getLastModifiedBy() != null);
		//assertTrue(book.getLastModifiedDate() != null);
	}

}
