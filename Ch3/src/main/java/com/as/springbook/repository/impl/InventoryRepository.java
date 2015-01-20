/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.repository.impl;

import org.springframework.stereotype.Repository;

import com.as.springbook.domain.Inventory;
import com.as.springbook.domain.common.AbstractHibernateRepository;
import com.as.springbook.repository.IInventoryRepository;

/**
 * @author komatsu
 *
 */

@Repository
public class InventoryRepository extends AbstractHibernateRepository<Inventory> implements IInventoryRepository{

	public InventoryRepository(){
		super();
		setClass(Inventory.class);
	}
}
