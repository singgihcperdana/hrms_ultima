package com.dashen.hrms.dao;

import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@Repository
public class LeaveDao {

    @Autowired
    SessionFactory sessionFactory;
    
    public LeaveDao(){}
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public <T> Serializable insert(T entity) {

        return sessionFactory.getCurrentSession().save(entity);
    }

    public <T> T update(T entity) {

        sessionFactory.getCurrentSession().update(entity);

        return entity;
    }

    public <T> void delete(T entity) {

        sessionFactory.getCurrentSession().delete(entity);

    }
    public <T> List findAll(String query) {

        return sessionFactory.getCurrentSession().createQuery(query).list();
    }

    public <T> List<T> findAll(Class<T> entityClass){
        
        

        return  sessionFactory.getCurrentSession().createQuery("from LeaveRequest").list();
        
    }

    public <T> T findById(Serializable id,Class<T> entityClass) {
        return (T)sessionFactory.getCurrentSession().get(entityClass,id);
    }

}
