/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.service;

import com.dashen.hrms.SalaryDetail;
import com.dashen.hrms.dao.SalaryDetailDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author biniamt
 */

@Service
public class SalaryDetailService {
    
    @Autowired
    SalaryDetailDao salaryDetailDao;

    public void setSalaryDetailDao(SalaryDetailDao salaryDetailDao) {
        this.salaryDetailDao = salaryDetailDao;
    }

    @Transactional
    public boolean saveNewSalaryDetail(SalaryDetail newSalaryDetail) {
        newSalaryDetail.setStatus("Active");
        
        for (SalaryDetail sd : listAll()) {
            if (sd.getStatus().equals("Active")) {
                sd.setStatus("Inactive");
                sd.setEndDate(new Date());
                salaryDetailDao.save(sd);
            }    
        }
        
        salaryDetailDao.save(newSalaryDetail);
        return true;
    }

    @Transactional
    public List<SalaryDetail> listAll() {
        return salaryDetailDao.listAll();
    }
    

    @Transactional
    public SalaryDetail getByID(String ID) {
        return salaryDetailDao.getByID(ID);
    }
    
}