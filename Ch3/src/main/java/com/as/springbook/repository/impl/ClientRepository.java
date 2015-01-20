/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.repository.impl;

import org.springframework.stereotype.Repository;

import com.as.springbook.domain.Client;
import com.as.springbook.domain.common.AbstractHibernateRepository;
import com.as.springbook.repository.IClientRepository;

/**
 * @author komatsu
 *
 */
@Repository
public class ClientRepository extends AbstractHibernateRepository<Client> implements IClientRepository {
	
    public ClientRepository() {
        super();
        setClass(Client.class);
    } 

}
