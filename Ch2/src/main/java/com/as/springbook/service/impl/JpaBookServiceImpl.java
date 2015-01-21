/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.service.impl;

import static java.util.Arrays.asList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.as.springbook.domain.Book;
import com.as.springbook.service.JpaBookService;

/**
 * @author komatsu
 *
 */

@Service
@Repository
@Transactional
public class JpaBookServiceImpl implements JpaBookService {

	private Log log = LogFactory.getLog(JpaBookServiceImpl.class);	
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Long countBooks() {
		return em.createQuery("SELECT COUNT(b) FROM book b", Long.class).getSingleResult();
	}
	
	/**
	 * @param sortName
	 * @param sortOrder
	 * @return
	 */
	@Transactional
	public List<Book> findAllOrder(String sortName, String orderName) {
		 String query = "SELECT b FROM book b";
	     if (asList("publishedDate", "lastName", "title").contains(sortName)) {
	         query = query + " ORDER BY " + sortName + orderName;
	     }
	     return em.createQuery(query, Book.class).getResultList();		
	}
	
	@Transactional(readOnly=true)
	public List<Book> findAll() {
		List<Book> Books = em.createQuery("SELECT b FROM book b", Book.class).getResultList();
		return Books;
	}

	@Transactional(readOnly=true)
	public Book findById(Long id) {
		TypedQuery<Book> query = em.createQuery("SELECT b FROM book b WHERE id = :id", Book.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	public Book save(Book book) {
		if (book.getId() == null) { 
			em.persist(book);
		} else {                      
			em.merge(book);
		}
		return book;
	}

	public void delete(Book book) {
		Book mergedBook = em.merge(book);
		em.remove(mergedBook);
	}
	
	@Transactional(readOnly=true)
	public List<Book> findAllByNativeQuery() {
		return em.createNativeQuery("select id, title, author_last_name, version from Book", "BookResult").getResultList();
	}

	public List<Book> findByFirstName(String firstName) {
		// Not implemented
		return null;
	}

	public List<Book> findByFirstNameAndLastName(String firstName,
			String lastName) {
		// Not implemented
		return null;
	}

	public List<Book> findByTitle(String firstName) {
		// Not implemented
		return null;
	}

	public List<Book> findByTitleAndPublishedYear(String firstName,
			String lastName) {
		// Not implemented
		return null;
	}

	public List<Book> findByCriteriaQuery(String firstName, String lastName) {
		// Not implemented
		return null;
	}

}