/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.dao;

import com.dashen.hrms.Allowance;
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
public class AllowanceDao {
    @Autowired
    SessionFactory sessionFactory;    

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void save(Allowance allowance)
    {
        Session session = sessionFactory.getCurrentSession();        
        session.saveOrUpdate(allowance);  
       
    }

    public List<Allowance> listAll()
    {
        List<Allowance> list;
        Session session = sessionFactory.getCurrentSession();
        Query qr = session.createQuery("from Allowance");
        list = qr.list();        
        return list;
    }
  
    public Allowance getByID(String ID)
    {
        Session session = sessionFactory.getCurrentSession();
        Allowance allowance = (Allowance)session.get(Allowance.class, ID);
        return allowance;
    }
}