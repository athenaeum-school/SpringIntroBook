/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.repository.impl;

import org.springframework.stereotype.Repository;

import com.as.springbook.domain.Rental;
import com.as.springbook.domain.common.AbstractHibernateRepository;
import com.as.springbook.repository.IRentalRepository;

/**
 * @author komatsu
 *
 */
@Repository
public class RentalRepository extends AbstractHibernateRepository<Rental> implements IRentalRepository {

	public RentalRepository(){
		super();
		setClass(Rental.class);
	}
	
}
