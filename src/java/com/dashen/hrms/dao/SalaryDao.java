/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.dao;

import com.dashen.hrms.Salary;
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
public class SalaryDao {
    @Autowired
    SessionFactory sessionFactory;    

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void save(Salary salary)
    {
        Session session = sessionFactory.getCurrentSession();        
        session.saveOrUpdate(salary);  
       
    }

    public List<Salary> listAll()
    {
        List<Salary> list;
        Session session = sessionFactory.getCurrentSession();
        Query qr = session.createQuery("from Salary");
        list = qr.list();        
        return list;
    }
  
    public Salary getByID(String ID)
    {
        Session session = sessionFactory.getCurrentSession();
        Salary salary = (Salary)session.get(Salary.class, ID);        
        return salary;
    }
}