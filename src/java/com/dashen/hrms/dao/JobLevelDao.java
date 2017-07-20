/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.dao;

import com.dashen.hrms.JobLevel;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author biniamt
 */

@Repository
@Transactional
public class JobLevelDao {
    @Autowired
    SessionFactory sessionFactory;    

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void save(JobLevel jobLevel)
    {
        Session session = sessionFactory.getCurrentSession();        
        session.saveOrUpdate(jobLevel);  
       
    }

    public List<JobLevel> listAll()
    {
        List<JobLevel> list;
        Session session = sessionFactory.getCurrentSession();
        Query qr = session.createQuery("from JobLevel");
        list = qr.list();        
        return list;
    }
  
    public JobLevel getByID(String ID)
    {
        Session session = sessionFactory.getCurrentSession();
        JobLevel jobLevel = (JobLevel)session.get(JobLevel.class, ID);        
        return jobLevel;
    }
}