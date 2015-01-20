/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.as.springbook.config.HibernateConfig;
import com.as.springbook.domain.Book;
import com.as.springbook.domain.Inventory;
import com.as.springbook.domain.Rental;

/**
 * @author komatsu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HibernateConfig.class }, loader = AnnotationConfigContextLoader.class)
public class BookServiceTest {
	
	    @Autowired
	    private BookService bookService;
	    
	    @Autowired
	    private InventoryService inventoryService;
	    
	    @Autowired
	    private RentalService rentalService;
	    
		/**
		 * @throws java.lang.Exception
		 */
		@Before
		public void setUp() throws Exception {
			Book book = new Book();
			book.setTitle("Wonder book");
			book.setFirstName("Gozzila");
			book.setLastName("Taro");
			book.setIsbn("89378428397898aa");
			bookService.create(book);
			
			Book book2 = new Book();
			book2.setTitle("Wonder book 2");
			book2.setFirstName("Siren");
			book2.setLastName("Mule");
			book2.setIsbn("8937sss8397898aa");
			bookService.create(book2);
			
			Inventory inventory = new Inventory();
			inventory.setBook(book);
			inventory.setStock(1l);
			inventoryService.create(inventory);
			
			Inventory inventory2 = new Inventory();
			inventory2.setBook(book);
			inventory2.setStock(4l);
			inventoryService.create(inventory2);
			
			Inventory inventory3 = new Inventory();
			inventory3.setBook(book2);
			inventory3.setStock(2l);
			inventoryService.create(inventory3);		
			
			Rental rental = new Rental();
			rental.setInventory(inventory);
			rental.setActive(true);
			rentalService.create(rental);
			
			Rental rental2 = new Rental();
			rental2.setInventory(inventory2);
			rental2.setActive(true);
			rentalService.create(rental2);
			
			Rental rental3 = new Rental();
			rental3.setInventory(inventory2);
			rental3.setActive(true);
			rentalService.create(rental3);
		}

		/**
		 * @throws java.lang.Exception
		 */
		@After
		public void tearDown() throws Exception {

		}
	    
	    @Test
	    public final void testFindOne() {
	    	Book book = bookService.findOne(1l);
	    	assertNotNull(book.getInventory());
	    }

	    @Test
	    public final void testFindAll() {
	    	List<Book> books = bookService.findAll();
	    	
	    	for(Book book : books) {
		    	List<Inventory> inventories = book.getInventory(); 
		    	for(Inventory inventory : inventories) {
		    		List<Rental> rentals = inventory.getRental();
		    		for(Rental rental : rentals) {
		    			System.out.println("title : " + book.getTitle() + " : stock = " + inventory.getStock() + " : rental status :" + rental.getActive());
		    		}
		    	}	    		
	    	}
	    	
	    	assertNotNull(books.get(1));
	    }
}
