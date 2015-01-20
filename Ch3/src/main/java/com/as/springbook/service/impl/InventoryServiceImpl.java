/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.springbook.domain.Inventory;
import com.as.springbook.domain.common.CommonActions;
import com.as.springbook.repository.IInventoryRepository;
import com.as.springbook.service.InventoryService;
import com.as.springbook.service.common.AbstractApplicationComponent;

@Service
public class InventoryServiceImpl extends AbstractApplicationComponent<Inventory> implements InventoryService {

    @Autowired
    private IInventoryRepository inventoryRepository;

    public InventoryServiceImpl() {
        super();
    }

    @Override
    protected CommonActions<Inventory> getCommonRepository() {
        return inventoryRepository;
    }

}
