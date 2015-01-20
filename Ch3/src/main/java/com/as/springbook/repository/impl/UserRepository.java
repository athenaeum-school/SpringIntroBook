/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.repository.impl;

import org.springframework.stereotype.Repository;

import com.as.springbook.domain.UserImpl;
import com.as.springbook.domain.common.AbstractHibernateRepository;
import com.as.springbook.repository.IUserRepository;

/**
 * @author komatsu
 *
 */
@Repository
public class UserRepository extends AbstractHibernateRepository<UserImpl> implements IUserRepository {

    public UserRepository() {
        super();
        setClass(UserImpl.class);
    }
	
}
