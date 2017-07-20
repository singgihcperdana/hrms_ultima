/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.dao;

import com.dashen.hrms.AllowanceType;
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
public class AllowanceTypeDao {
    @Autowired
    SessionFactory sessionFactory;    

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void save(AllowanceType allowanceType)
    {
        Session session = sessionFactory.getCurrentSession();        
        session.saveOrUpdate(allowanceType);  
       
    }

    public List<AllowanceType> listAll()
    {
        List<AllowanceType> list;
        Session session = sessionFactory.getCurrentSession();
        Query qr = session.createQuery("from AllowanceType");
        list = qr.list();        
        return list;
    }
  
    public AllowanceType getByID(String ID)
    {
        Session session = sessionFactory.getCurrentSession();
        AllowanceType allowanceType = (AllowanceType)session.get(AllowanceType.class, ID);        
        return allowanceType;
    }
}