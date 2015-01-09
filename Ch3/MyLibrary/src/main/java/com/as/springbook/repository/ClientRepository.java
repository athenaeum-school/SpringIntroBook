/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.repository;

import com.as.springbook.domain.BookImpl;
import com.as.springbook.domain.ClientImpl;
import com.as.springbook.domain.common.AbstractHibernateRepository;

/**
 * @author komatsu
 *
 */
public class ClientRepository extends AbstractHibernateRepository<ClientImpl> implements IClientRepository {
	
    public ClientRepository() {
        super();
        setClass(ClientImpl.class);
    } 

}
