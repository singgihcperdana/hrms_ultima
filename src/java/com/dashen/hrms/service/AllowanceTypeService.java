/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.service;

import com.dashen.hrms.AllowanceType;
import com.dashen.hrms.dao.AllowanceTypeDao;
import com.dashen.hrms.dao.EmployeeTmpDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author biniamt
 */


@Service
public class AllowanceTypeService {
    
    @Autowired
    AllowanceTypeDao allowanceTypeDao;

    @Autowired
    private EmployeeTmpDao empTmpDao;

    public void setAllowanceTypeDao(AllowanceTypeDao allowanceTypeDao) {
        this.allowanceTypeDao = allowanceTypeDao;
    }

    @Transactional
    public boolean saveNewAllowanceType(AllowanceType newAllowanceType) {
        allowanceTypeDao.save(newAllowanceType);
        return true;
    }
    
    @Transactional
    public List<AllowanceType> listAll() {
        return allowanceTypeDao.listAll();
    }
    

    @Transactional
    public AllowanceType getByID(String ID) {
        return allowanceTypeDao.getByID(ID);
    }
    
}
