/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.domain.common;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author komatsu
 *
 */
public class AbstractJpaRepository <T extends Serializable> implements CommonActions<T>{

	@PersistenceContext
	static EntityManager entityManager;

	private Class<T> myClass;
    
    protected final void setClass(final Class<T> myClass) {
    	this.myClass = myClass;
    }
	
	public static final EntityManager entityManager() {
        EntityManager em = entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected.");
        return em;
    }
	
	@Override
	public T findOne(long id) {
		//entityManager().createQuery("select o.id from  ", Long.class);
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T update(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long entityId) {
		// TODO Auto-generated method stub
		
	}

}
