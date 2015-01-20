/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.domain.common;

import java.io.Serializable;
import java.util.List;

import com.as.springbook.annotation.RetryLock;

public interface CommonActions<T extends Serializable>  {

	/**
	 * Find the element by id. Typically, id stands for
	 * the primary key.
	 * @param id
	 * @return T
	 */
    T findOne(final long id);
    
    /**
     * Find all the elements associated with T.
     * @return List<T>
     */
    List<T> findAll();
    
    /**
     * Persist the entity to the database.
     * @param entity
     */
    void create(final T entity);
    
    /**
     * Persist and save the entity in the database.
     * @param entity
     * @return T
     */
    T update(final T entity);
    
    /**
     * Delete the element from the database.
     * @param entity
     */
    void delete(final T entity);
    
    /**
     * Delete the element by Id column.
     * @param entityId
     */
    void deleteById(final long entityId);

}
