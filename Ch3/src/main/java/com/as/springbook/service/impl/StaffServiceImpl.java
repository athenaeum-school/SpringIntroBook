/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.as.springbook.domain.Staff;
import com.as.springbook.domain.common.CommonActions;
import com.as.springbook.repository.IStaffRepository;
import com.as.springbook.service.StaffService;
import com.as.springbook.service.common.AbstractApplicationComponent;

/**
 * @author komatsu
 *
 */
public class StaffServiceImpl extends AbstractApplicationComponent<Staff> implements StaffService {

    @Autowired
    private IStaffRepository staffRepository;

    public StaffServiceImpl() {
        super();
    }

    @Override
    protected CommonActions<Staff> getCommonRepository() {
        return staffRepository;
    }
}
