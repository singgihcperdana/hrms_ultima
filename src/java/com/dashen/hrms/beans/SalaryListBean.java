/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.beans;

import com.dashen.hrms.Salary;
import com.dashen.hrms.service.SalaryService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 *
 * @author biniamt
 */

@Component
@RequestScope
public class SalaryListBean {

    private List<Salary> salaryList;
    List<Salary> selectedSalaries;

    @Autowired
    private SalaryService salaryService;

    @PostConstruct
    public void init() {
        salaryList = salaryService.listAll();
    }

    public List<Salary> getSalaryList() {
        return salaryList;
    }

    public void setSalaryList(List<Salary> salaryList) {
        this.salaryList = salaryList;
    }

    public List<Salary> getSelectedSalaries() {
        return selectedSalaries;
    }

    public void setSelectedSalaries(List<Salary> selectedSalaries) {
        this.selectedSalaries = selectedSalaries;
    }
}
