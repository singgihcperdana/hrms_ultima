/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.dao;

import com.dashen.hrms.LeaveRequest;
import com.dashen.hrms.TempStatus;
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
public class LeaveRequestDao {

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveNew(LeaveRequest q) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(q);
    }

    public void update(LeaveRequest q) {
        Session session = sessionFactory.getCurrentSession();
        session.update(q);
    }

    public List<LeaveRequest> listAll() {
        List<LeaveRequest> list;
        Session session = sessionFactory.getCurrentSession();
        Query qr = session.createQuery("from LeaveRequest");
        list = qr.list();
        return list;
    }

    public LeaveRequest getByLeaverequestID(String id) {
        Session session = sessionFactory.getCurrentSession();
        LeaveRequest ql = (LeaveRequest) session.get(LeaveRequest.class, id);
        return ql;
    }

    public List<LeaveRequest> getByEmployeeSerialID(String id) {
        List<LeaveRequest> list;
        Session session = sessionFactory.getCurrentSession();
        //query to get the qualifications of an employee
        Query qr = session.createQuery("from LeaveRequest where employee_serial_id = '" + id + "'");
        list = qr.list();
        return list;
    }
    
    public List<LeaveRequest> listAllLeaveRequestForMaker(String makerID) {
        List<LeaveRequest> list;
        Session session = sessionFactory.getCurrentSession();
        Query qr = session.createQuery("from LeaveRequest where MAKER_USER_ID = '" + makerID + "'");
        list = qr.list();
        return list;
    }
    
    public List<LeaveRequest> listPendingLeaveRequestForMaker(String makerID)
    {
        List<LeaveRequest> list;
        Session session = sessionFactory.getCurrentSession();
        Query qr = session.createQuery("from LeaveRequest where MAKER_USER_ID = '" + makerID + "' and ( MAKER_CHECKER_STATUS = '" + TempStatus.EDITABLE + "' or MAKER_CHECKER_STATUS ='" + TempStatus.SUBMITTED + "')");
        list = qr.list();
        return list;
    }
    
    public List<LeaveRequest> listLeaveRequestForChecker(String checkerID)
    {
         List<LeaveRequest> list;
        Session session = sessionFactory.getCurrentSession();
        Query qr = session.createQuery("from LeaveRequest where MAKER_CHECKER_STATUS ='" + TempStatus.SUBMITTED + "'");
        list = qr.list();
        return list;
    }

    public List<LeaveRequest> listAllForMakerRole() {

        List<LeaveRequest> list;
        Session session = sessionFactory.getCurrentSession();
        Query qr = session.createQuery("from LeaveRequest where MAKER_CHECKER_STATUS ='" + TempStatus.EDITABLE + "'");
        list = qr.list();
        return list;
    }
}
