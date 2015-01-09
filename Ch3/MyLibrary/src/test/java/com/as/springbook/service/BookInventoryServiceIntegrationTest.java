package com.as.springbook.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.as.springbook.config.HibernateConfig;
import com.as.springbook.domain.BookImpl;
import com.as.springbook.domain.InventoryImpl;
import com.as.springbook.service.BookService;
import com.as.springbook.service.InventoryService;

/**
 * Service and Data access layer integration test isolates
 * entity relationship consistency from the unit test functional
 * and application-level data integrity concerns.
 * @author komatsu
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HibernateConfig.class }, loader = AnnotationConfigContextLoader.class)
public class BookInventoryServiceIntegrationTest {
	
	    @Autowired
	    private BookService bookService;
	    
	    @Autowired
	    private InventoryService inventoryService;	    

	    @Test
	    public final void testNoExceptions() {

	    }

	    @Test
	    public final void testExceptionsIfTwoEntitiesAreCreated() {
	        final BookImpl book = new BookImpl();
	        book.setTitle("OurWonderfulBook");
	        bookService.create(book);

	        final InventoryImpl inventory = new InventoryImpl();
	        inventoryService.create(inventory);
	    }

	    @Test(expected = DataIntegrityViolationException.class)
	    public final void testDataIntegrityExceptionOnDeletionWithForeignKeyPresent() {
	        final BookImpl book = new BookImpl();
	        book.setTitle("OurWonderfulBook");
	        bookService.create(book);

	        final InventoryImpl inventory = new InventoryImpl(book);
	        inventoryService.create(inventory);

	        bookService.delete(book);
	    }

	    @Test
	    public final void testNoExceptionsIfForeignKeyIsDeletedBeforeDeletingChild() {
	        final BookImpl book = new BookImpl();
	        book.setTitle("OurWonderfulBook");
	        bookService.create(book);

	        final InventoryImpl inventory = new InventoryImpl(book);
	        inventoryService.create(inventory);

	        inventoryService.delete(inventory);
	        bookService.delete(book);
	    }

}