/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.domain;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import org.springhibernate.demo.Item;
import org.springhibernate.demo.Order;

import com.as.springbook.config.HibernateConfig;
import com.as.springbook.config.HibernateDaoConfig;

/**
 * @author komatsu
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HibernateDaoConfig.class }, loader = AnnotationConfigContextLoader.class)
public class BookImplTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	@Transactional
	public void SaveBookWithInventoryTest() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		BookImpl book = new BookImpl();
		book.setId(1l);
		book.setTitle("My Second Favorite Book");
		book.getInventoryImpl().add(new InventoryImpl());
		session.save(book);
		session.flush();
		assertNotNull(book.getId());
	}
	
	@Test
	@Transactional
	public void SaveAndGetTest() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		BookImpl book = new BookImpl();
		book.setId(1l);
		book.setTitle("My Second Favorite Book");
		book.getInventoryImpl().add(new InventoryImpl());
		session.save(book);
		session.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		session.clear();
		BookImpl other = (BookImpl) session.get(BookImpl.class, book.getId());
		assertEquals(1, other.getInventoryImpl().size());
		//assertEquals(other, other.getInventoryImpl().iterator().next().getBook());
	}

	@Test
	@Transactional
	public void SaveAndFindTest() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		RentalImpl rental = new RentalImpl();
		InventoryImpl inventory = new InventoryImpl();
		BookImpl book = new BookImpl();
		inventory.setBook(book);
		rental.getInventory().add(inventory);
		session.save(rental);
		session.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		session.clear();
		RentalImpl other = (RentalImpl) session
				.createQuery( "select r from rental o join r.inventory r where r.book=:book")
				.setString("book", "My Second Favorite Book").uniqueResult();
		assertEquals(1, other.getInventory().size());
		assertEquals(other, other.getInventory().iterator().next().getRental());
	}

}
