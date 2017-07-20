/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.dao;

import com.dashen.hrms.Employee;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MulugetaK
 */
@Repository
@Transactional
public class EmployeeDao {

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveNew(Employee emp) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(emp);
    }

    public void Update(Employee emp) {
        Session session = sessionFactory.getCurrentSession();
        session.update(emp);
    }

    public List<Employee> listAll() {
        List<Employee> list;
        Session session = sessionFactory.getCurrentSession();
        Query qr = session.createQuery("from Employee");
        list = qr.list();
        return list;
    }

    public Employee getByEmployeeSerialID(String employeeSerialID) {
        Session session = sessionFactory.getCurrentSession();
        Employee emp = (Employee) session.get(Employee.class, employeeSerialID);
        return emp;
    }

    public List<Employee> searchEmployee(String employeeId, String firstName, String middleName, String lastName, String fileIndexNo) {
        List<Employee> list = new ArrayList();
        String condition = "";
        if (employeeId != null && !employeeId.isEmpty()) {
            employeeId = employeeId.trim();
            condition = " employeeID = '" + employeeId + "' ";
        }
        if (firstName != null && !firstName.isEmpty()) {
            firstName = firstName.trim();
            condition += condition.isEmpty() ? " firstName like '%" + firstName + "%'": " AND firstName like '%" + firstName + "%'";
        }
        if (middleName != null && !middleName.isEmpty()) {
            middleName = middleName.trim();
            condition += condition.isEmpty() ? " middleName like '%" + middleName + "%'": " AND middleName like '%" + middleName + "%'";
        }
        if (lastName != null && !lastName.isEmpty()) {
            lastName = lastName.trim();
            condition += condition.isEmpty() ? " lastName like '%" + lastName + "%'": " AND lastName like '%" + lastName + "%'";
        }
        if (fileIndexNo != null && !fileIndexNo.isEmpty()) {
            fileIndexNo = fileIndexNo.trim();
            condition += condition.isEmpty() ? " fileIndexNumber = '" + fileIndexNo + "' " : " AND fileIndexNumber = '" + fileIndexNo + "' ";
        }

        if(condition.isEmpty())
        {
            //no need of querying database just return empty list
            return  list;
        }
        String query = "from Employee where " + condition;
        System.out.println(query);
        Session session = sessionFactory.getCurrentSession();
        Query qr = session.createQuery(query);
        list = qr.list();
        return list;
    }

}
