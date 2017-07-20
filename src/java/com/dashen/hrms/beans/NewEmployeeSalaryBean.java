/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.beans;

import com.dashen.hrms.Department;
import com.dashen.hrms.Employee;
import com.dashen.hrms.EmployeeSalary;
import com.dashen.hrms.JobGrade;
import com.dashen.hrms.JobLevel;
import com.dashen.hrms.Position;
import com.dashen.hrms.Salary;
import com.dashen.hrms.service.DepartmentService;
import com.dashen.hrms.service.EmployeeSalaryService;
import com.dashen.hrms.service.EmployeeService;
import com.dashen.hrms.service.JobGradeService;
import com.dashen.hrms.service.JobLevelService;
import com.dashen.hrms.service.PositionService;
import com.dashen.hrms.service.SalaryService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 *
 * @author biniamt
 */

@Component
@RequestScope
public class NewEmployeeSalaryBean {
    
    private EmployeeSalary newEmployeeSalary;

    @Autowired
    private EmployeeSalaryService employeeSalaryService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private SalaryService salaryService;
       
    private List<SelectItem> employeeList;
    private List<SelectItem> salaryList;

    public EmployeeSalary getNewEmployeeSalary() {
        return newEmployeeSalary;
    }

    public void setNewEmployeeSalary(EmployeeSalary newEmployeeSalary) {
        this.newEmployeeSalary = newEmployeeSalary;
    }

    public List<SelectItem> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<SelectItem> employeeList) {
        this.employeeList = employeeList;
    }

    public List<SelectItem> getSalaryList() {
        return salaryList;
    }

    public void setSalaryList(List<SelectItem> salaryList) {
        this.salaryList = salaryList;
    }
    
    

    @PostConstruct
    public void init() {
        newEmployeeSalary = new EmployeeSalary();
        employeeList = new ArrayList<>();
        salaryList = new ArrayList<>();
        
        List<Employee> eList = employeeService.listAll();
        for (Employee e: eList) {
            employeeList.add(new SelectItem(e.getEmployeeSerialID(), e.getFullName()));
        }
        
        List<Salary> sList = salaryService.listAll();
        for (Salary s : sList) {
            Department department;
            JobGrade jobGrade;
            JobLevel jobLevel;
            Position position;
            
            String dName = "";
            String pTitle = "";
            String jGrade = "";
            String jLevel = "";
            
            try {
                department = s.getDepartment();
                dName = department.getName();
            } catch (Exception e) {
                                                
            }
            try {
                jobGrade = s.getGrade();
                jGrade = jobGrade.getGrade();
            } catch (Exception e) {}
                        
            try {
                jobLevel = s.getLevel();
                jLevel = jobLevel.getLevel();
            } catch (Exception e) {}
            
            try {
                position = s.getPosition();
                pTitle = position.getTitle();
            } catch (Exception e) {}
            
            salaryList.add(new SelectItem(s.getID(), dName + " / " + pTitle + " / " + jGrade + " / " + jLevel));
        }
    }

    public void btnSaveNewEmployeeSalary_Handler() {
        employeeSalaryService.saveNewEmployeeSalary(newEmployeeSalary);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "New Employee Salary", "New employee salary is saved.");
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }
}
