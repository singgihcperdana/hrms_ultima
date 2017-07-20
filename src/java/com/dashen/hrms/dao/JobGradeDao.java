/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.dao;

import com.dashen.hrms.JobGrade;
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
public class JobGradeDao {
    @Autowired
    SessionFactory sessionFactory;    

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void save(JobGrade jobGrade)
    {
        Session session = sessionFactory.getCurrentSession();        
        session.saveOrUpdate(jobGrade);  
       
    }

    public List<JobGrade> listAll()
    {
        List<JobGrade> list;
        Session session = sessionFactory.getCurrentSession();
        Query qr = session.createQuery("from JobGrade");
        list = qr.list();        
        return list;
    }
  
    public JobGrade getByID(String ID)
    {
        Session session = sessionFactory.getCurrentSession();
        JobGrade jobGrade = (JobGrade)session.get(JobGrade.class, ID);        
        return jobGrade;
    }
}