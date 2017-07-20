/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.beans;

import com.dashen.hrms.ActionType;
import com.dashen.hrms.dao.LeaveDao;
import com.dashen.hrms.service.LeaveService;
import com.dashen.hrms.LeaveRequest;
import com.dashen.hrms.CustomUserDetailsService;
import com.dashen.hrms.Employee;
import com.dashen.hrms.EmployeeTmp;
import com.dashen.hrms.LeaveEnum;
import com.dashen.hrms.LeaveType;
import com.dashen.hrms.SpringViewScope;
import com.dashen.hrms.TempStatus;
import com.dashen.hrms.dao.LeaveRequestDao;
import com.dashen.hrms.service.EmployeeService;
import com.sun.javafx.util.TempState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;


/**
 *
 * @author Daniel Adenew
 */
@Component
@SpringViewScope
public class LeaveRequestBean {
    
  
    private LeaveRequest leaveRequesModel;
    
    private String ltype;
    private List<SelectItem> leaveType;
    private List<SelectItem> employees;
    
    @Autowired(required=true)
    LeaveRequestDao dao;
    
    @Autowired(required=true)
    CustomUserDetailsService userService;
    
    @Autowired(required=true)
    EmployeeService empService;
    
    @Autowired(required=true)
    LeaveService leaveService;
    
    public LeaveRequestBean() {
      
    }
    
 
    @PostConstruct
    public void init() {
        leaveRequesModel = new LeaveRequest();  
        
        leaveType = new ArrayList<>();
        employees = new ArrayList<>();
        List<LeaveType> leaveTypes = new ArrayList<>();
        
        leaveTypes = leaveService.getLeaveTypes();
        
        List<Employee> employeeList = new ArrayList<>();
        employeeList = empService.listAll();
        
        
        System.out.println("employeeList "+employeeList);

        System.out.println("leave tyoes"+leaveTypes+leaveTypes);
     
        for (Employee jbCl : employeeList) {
            employees.add(new SelectItem(jbCl.getEmployeeSerialID(), "EMP_ID-"+jbCl.getEmployeeID()+"-Full Name-"+jbCl.getFullName()));
        }
        
        
        for (LeaveType jbCl : leaveTypes) {
            leaveType.add(new SelectItem(jbCl.getID(), jbCl.getTitle()));
        }
       
        System.out.println("leave tyoes"+leaveTypes+leaveType);
        

    }
    public void SaveNewLeaveRequest() {
        
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Leave Request", "Leave Request is saved.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        leaveRequesModel.getApprover_first_name();
        User currentUserDetails = LeaveService.getCurrentUser();
        leaveRequesModel.setMaker_user_id(currentUserDetails.getUsername());
        leaveRequesModel.setMaker_checker_status(TempStatus.EDITABLE);
        leaveRequesModel.setLeave_status(LeaveEnum.APPROVED);

        //leaveRequesModel.setLeave_type("hello");
        //System.out.println(leaveRequesModel.getLeave_type());
        dao.saveNew(leaveRequesModel);
        leaveRequesModel = new LeaveRequest();  
        return;
               
    }

    public LeaveRequest getLeaveModel() {
        return leaveRequesModel;
    }

    public void setLeaveModel(LeaveRequest leaveModel) {
        this.leaveRequesModel = leaveModel;
    }

    public LeaveRequest getLeaveRequesModel() {
        return leaveRequesModel;
    }

    public void setLeaveRequesModel(LeaveRequest leaveRequesModel) {
        this.leaveRequesModel = leaveRequesModel;
    }

    public List<SelectItem> getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(List<SelectItem> leaveType) {
        this.leaveType = leaveType;
    }

    public CustomUserDetailsService getUserService() {
        return userService;
    }

    public void setUserService(CustomUserDetailsService userService) {
        this.userService = userService;
    }

    public String getLtype() {
        return ltype;
    }

    public void setLtype(String ltype) {
        this.ltype = ltype;
    }
    
    public void calculate_leavehours() {
        
        Double hours = Double.parseDouble(leaveRequesModel.getTime_span_hours());
        hours*=8.0;
    
        leaveRequesModel.setTime_span_hours(hours.toString());
      
    }

    public List<SelectItem> getEmployees() {
        return employees;
    }

    public void setEmployees(List<SelectItem> employees) {
        this.employees = employees;
    }

    public EmployeeService getEmpService() {
        return empService;
    }

    public void setEmpService(EmployeeService empService) {
        this.empService = empService;
    }

    public LeaveService getLeaveService() {
        return leaveService;
    }

    public void setLeaveService(LeaveService leaveService) {
        this.leaveService = leaveService;
    }
    
    
    
      
}
