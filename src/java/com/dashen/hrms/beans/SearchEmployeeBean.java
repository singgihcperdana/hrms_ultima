/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.beans;

import com.dashen.hrms.Employee;
import com.dashen.hrms.SpringViewScope;
import com.dashen.hrms.service.EmployeeService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mulugetak
 */
@SpringViewScope
@Component
public class SearchEmployeeBean implements Serializable {

    @Autowired
    private EmployeeService empService;

    private List<Employee> searchResultList;

    private String employeeId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fileIndexNo;

    @PostConstruct
    public void init() {
        searchResultList = new ArrayList<>();
        employeeId = "";
        firstName = "";
        middleName = "";
        lastName = "";
        fileIndexNo = "";
    }

    public List<Employee> getSearchResultList() {
        return searchResultList;
    }

    public void setSearchResultList(List<Employee> searchResultList) {
        this.searchResultList = searchResultList;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFileIndexNo() {
        return fileIndexNo;
    }

    public void setFileIndexNo(String fileIndexNo) {
        this.fileIndexNo = fileIndexNo;
    }

    public void search() {
        searchResultList = empService.searchEmployee(employeeId, firstName, middleName, lastName, fileIndexNo);
    }
}
