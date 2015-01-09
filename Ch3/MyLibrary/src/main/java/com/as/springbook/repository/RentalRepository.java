/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.repository;

import org.springframework.stereotype.Repository;

import com.as.springbook.domain.RentalImpl;
import com.as.springbook.domain.common.AbstractHibernateRepository;

/**
 * @author komatsu
 *
 */
@Repository
public class RentalRepository extends AbstractHibernateRepository<RentalImpl> implements IRentalRepository {

	public RentalRepository(){
		super();
		setClass(RentalImpl.class);
	}
	
}
