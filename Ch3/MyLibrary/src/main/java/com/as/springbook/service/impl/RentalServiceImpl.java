/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.as.springbook.domain.BookImpl;
import com.as.springbook.domain.RentalImpl;
import com.as.springbook.domain.common.CommonActions;
import com.as.springbook.repository.IBookRepository;
import com.as.springbook.repository.IRentalRepository;
import com.as.springbook.service.BookService;
import com.as.springbook.service.RentalService;
import com.as.springbook.service.common.AbstractApplicationComponent;

/**
 * @author komatsu
 *
 */
public class RentalServiceImpl  extends AbstractApplicationComponent<RentalImpl> implements RentalService {

    @Autowired
    private IRentalRepository rentalRepository;

    public RentalServiceImpl() {
        super();
    }

    @Override
    protected CommonActions<RentalImpl> getCommonRepository() {
        return rentalRepository;
    }

}
