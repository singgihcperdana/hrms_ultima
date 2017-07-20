/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.service;

import com.dashen.hrms.JobGrade;
import com.dashen.hrms.dao.JobGradeDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author biniamt
 */


@Service
public class JobGradeService {
    @Autowired
    JobGradeDao jobGradeDao;

    public void setJobGradeDao(JobGradeDao jobGradeDao) {
        this.jobGradeDao = jobGradeDao;
    }

    @Transactional
    public boolean saveNewJobGrade(JobGrade newJobGrade) {
        jobGradeDao.save(newJobGrade);
        return true;
    }

    @Transactional
    public List<JobGrade> listAll() {
        return jobGradeDao.listAll();
    }
    
    @Transactional
    public JobGrade getByID(String ID) {
        return jobGradeDao.getByID(ID);
    }
}
