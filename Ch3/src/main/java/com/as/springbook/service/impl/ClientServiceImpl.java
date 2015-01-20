/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.as.springbook.domain.Client;
import com.as.springbook.domain.common.CommonActions;
import com.as.springbook.repository.IClientRepository;
import com.as.springbook.service.ClientService;
import com.as.springbook.service.common.AbstractApplicationComponent;

public class ClientServiceImpl extends AbstractApplicationComponent<Client> implements ClientService {

    @Autowired
    private IClientRepository clientRepository;

    public ClientServiceImpl() {
        super();
    }

    @Override
    protected CommonActions<Client> getCommonRepository() {
        return clientRepository;
    }
}
