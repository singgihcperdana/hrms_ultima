/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.dao;

import com.dashen.hrms.SalaryDetail;
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
public class SalaryDetailDao {
    @Autowired
    SessionFactory sessionFactory;    

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void save(SalaryDetail salaryDetail)
    {
        Session session = sessionFactory.getCurrentSession();        
        session.saveOrUpdate(salaryDetail);  
       
    }

    public List<SalaryDetail> listAll()
    {
        List<SalaryDetail> list;
        Session session = sessionFactory.getCurrentSession();
        Query qr = session.createQuery("from SalaryDetail");
        list = qr.list();        
        return list;
    }
  
    public SalaryDetail getByID(String ID)
    {
        Session session = sessionFactory.getCurrentSession();
        SalaryDetail salaryDetail = (SalaryDetail)session.get(SalaryDetail.class, ID);        
        return salaryDetail;
    }
}