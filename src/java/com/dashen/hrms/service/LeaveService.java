package com.dashen.hrms.service;


import com.dashen.hrms.LeaveRequest;
import com.dashen.hrms.LeaveType;
import com.dashen.hrms.MyUser;
import com.dashen.hrms.dao.LeaveRequestDao;
import com.dashen.hrms.dao.LeaveTypeDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.ApplicationScope;


@ApplicationScope
@Service
public class LeaveService {
     
    @Autowired
    LeaveRequestDao dao; 
    
    @Autowired
    LeaveTypeDao leaveTypedao; 
    
    public LeaveService() {}
    
    public List<LeaveRequest> getLeaveRequest() {
        
        List<LeaveRequest> list;
        list = dao.listAllForMakerRole();
        return list;
   
        
    }
    
    public List<LeaveType> getLeaveTypes() {
        
        List<LeaveType> list;
        list = leaveTypedao.listAll();
        return list;

        
    }
    
    
    public LeaveRequest getLeaveRequestById(String leaveID ) {
        
        LeaveRequest leave;
        leave = dao.getByLeaverequestID(leaveID);
        return leave;
        
    }
    
    @Transactional
    public boolean delete(LeaveType leaveType) {
        leaveTypedao.delete(leaveType);
        return true;
    }
    
    @Transactional
    public boolean saveNewLeaveType(LeaveType leaveType) {
        leaveTypedao.saveNew(leaveType);
        return true;
    }
    
     @Transactional
    public boolean updateLeaveRequest(LeaveRequest leaveRequest) {
        dao.update(leaveRequest);
        return true;
    }
    
    

  
    public static void main(String args[]) {
    
        System.out.println(LeaveRequest.class.getSimpleName());
        
    }

    @Transactional
    public List<LeaveRequest> listPendingLeaveRequestForMaker(String makerID) {
        return dao.listPendingLeaveRequestForMaker(makerID);
    }

    @Transactional
    public List<LeaveRequest> listLeaveRequestForChecker(String checkerID) {
        return dao.listLeaveRequestForChecker(checkerID);
    }
    
    
    @Transactional
    public void updateLeaveType(LeaveType leaveType) {
       leaveTypedao.update(leaveType);
    }
    
    
 
    
    public static MyUser getCurrentUser() {
        MyUser myUsr = null;
        try {
            SecurityContext sc = SecurityContextHolder.getContext();
            Object principal = sc.getAuthentication().getPrincipal();
            myUsr = (MyUser) principal;
        } catch (Exception ex) {

        }
        return myUsr;
    }
}
  