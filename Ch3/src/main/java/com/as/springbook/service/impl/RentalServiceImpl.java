/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.springbook.domain.Rental;
import com.as.springbook.domain.common.CommonActions;
import com.as.springbook.repository.IRentalRepository;
import com.as.springbook.service.RentalService;
import com.as.springbook.service.common.AbstractApplicationComponent;

/**
 * @author komatsu
 *
 */

@Service
public class RentalServiceImpl  extends AbstractApplicationComponent<Rental> implements RentalService {

    @Autowired
    private IRentalRepository rentalRepository;

    public RentalServiceImpl() {
        super();
    }

    @Override
    protected CommonActions<Rental> getCommonRepository() {
        return rentalRepository;
    }

}
