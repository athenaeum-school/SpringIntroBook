/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.repository.impl;

import org.springframework.stereotype.Repository;

import com.as.springbook.domain.Staff;
import com.as.springbook.domain.common.AbstractHibernateRepository;
import com.as.springbook.repository.IStaffRepository;

/**
 * @author komatsu
 *
 */
@Repository
public class StaffRepository extends AbstractHibernateRepository<Staff> implements IStaffRepository {

    public StaffRepository() {
        super();
        setClass(Staff.class);
    }
	
}
