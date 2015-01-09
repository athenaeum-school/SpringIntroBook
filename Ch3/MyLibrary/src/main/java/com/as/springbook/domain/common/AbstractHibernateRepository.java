/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.domain.common;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
public abstract class AbstractHibernateRepository<T extends Serializable> implements CommonActions<T> {

	private Class<T> myClass;

    @Autowired
    private SessionFactory sessionFactory;
    
    protected final void setClass(final Class<T> myClass) {
    	this.myClass = myClass;
    }

    @Override
    public final T findOne(final long id) {
        return (T) getCurrentSession().get(myClass, id);
    }

    @Override
    public final List<T> findAll() {
        return getCurrentSession().createQuery("from " + myClass.getName()).list();
    }

    @Override
    public final void create(final T entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public final T update(final T entity) {
        return (T) getCurrentSession().merge(entity);
    }

    @Override
    public final void delete(final T entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public final void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        delete(entity);
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
