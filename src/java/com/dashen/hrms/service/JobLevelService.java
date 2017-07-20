/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.service;

import com.dashen.hrms.JobLevel;
import com.dashen.hrms.dao.JobLevelDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author biniamt
 */

@Service
public class JobLevelService {
    @Autowired
    JobLevelDao jobLevelDao;

    public void setJobLevelDao(JobLevelDao jobLevelDao) {
        this.jobLevelDao = jobLevelDao;
    }

    @Transactional
    public boolean saveNewJobLevel(JobLevel newJobLevel) {
        jobLevelDao.save(newJobLevel);
        return true;
    }

    @Transactional
    public List<JobLevel> listAll() {
        return jobLevelDao.listAll();
    }
    
    @Transactional
    public JobLevel getByID(String ID) {
        return jobLevelDao.getByID(ID);
    }
}
