/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.repository.impl;

import org.springframework.stereotype.Repository;

import com.as.springbook.domain.RoleImpl;
import com.as.springbook.domain.common.AbstractHibernateRepository;
import com.as.springbook.domain.common.CommonActions;
import com.as.springbook.repository.ILibraryRepository;
import com.as.springbook.repository.IRoleRepository;

/**
 * @author komatsu
 *
 */
@Repository
public class RoleRepository extends AbstractHibernateRepository<RoleImpl> implements IRoleRepository {

    public RoleRepository() {
        super();
        setClass(RoleImpl.class);
    }
	
}
