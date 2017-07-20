/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.service;

import com.dashen.hrms.Salary;
import com.dashen.hrms.dao.SalaryDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author biniamt
 */


@Service
public class SalaryService {
    
    @Autowired
    SalaryDao salaryDao;

    public void setSalaryDao(SalaryDao salaryDao) {
        this.salaryDao = salaryDao;
    }

    @Transactional
    public boolean saveNewSalary(Salary newSalary) {
        salaryDao.save(newSalary);
        return true;
    }

    @Transactional
    public List<Salary> listAll() {
        return salaryDao.listAll();
    }
    

    @Transactional
    public Salary getByID(String ID) {
        return salaryDao.getByID(ID);
    }
    
}
