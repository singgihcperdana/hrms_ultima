/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.service;

import com.dashen.hrms.Allowance;
import com.dashen.hrms.dao.AllowanceDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author biniamt
 */

@Service
public class AllowanceService {
    
    @Autowired
    AllowanceDao allowanceDao;

    public void setAllowanceDao(AllowanceDao allowanceDao) {
        this.allowanceDao = allowanceDao;
    }

    @Transactional
    public boolean saveNewAllowance(Allowance newAllowance) {
        newAllowance.setStatus("Active");
        allowanceDao.save(newAllowance);
        return true;
    }
    
    @Transactional
    public List<Allowance> listAll() {
        return allowanceDao.listAll();
    }
    

    @Transactional
    public Allowance getByID(String ID) {
        return allowanceDao.getByID(ID);
    }
    
}
