/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.repository;

import org.springframework.stereotype.Repository;

import com.as.springbook.domain.InventoryImpl;
import com.as.springbook.domain.common.AbstractHibernateRepository;

/**
 * @author komatsu
 *
 */

@Repository
public class InventoryRepository extends AbstractHibernateRepository<InventoryImpl> implements IInventoryRepository{

	public InventoryRepository(){
		super();
		setClass(InventoryImpl.class);
	}
}
