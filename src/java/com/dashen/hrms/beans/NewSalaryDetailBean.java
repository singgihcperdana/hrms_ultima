/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.beans;

import com.dashen.hrms.Department;
import com.dashen.hrms.JobGrade;
import com.dashen.hrms.JobLevel;
import com.dashen.hrms.Position;
import com.dashen.hrms.Salary;
import com.dashen.hrms.SalaryDetail;
import com.dashen.hrms.service.DepartmentService;
import com.dashen.hrms.service.JobGradeService;
import com.dashen.hrms.service.JobLevelService;
import com.dashen.hrms.service.PositionService;
import com.dashen.hrms.service.SalaryDetailService;
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
public class NewSalaryDetailBean {
    private SalaryDetail newSalaryDetail;

    @Autowired
    private SalaryDetailService salaryDetailService;
    @Autowired
    private SalaryService salaryService;

    private List<SelectItem> salaryList;

    public SalaryDetail getNewSalaryDetail() {
        return newSalaryDetail;
    }

    public void setNewSalaryDetail(SalaryDetail newSalaryDetail) {
        this.newSalaryDetail = newSalaryDetail;
    }

    public List<SelectItem> getSalaryList() {
        return salaryList;
    }

    public void setSalaryList(List<SelectItem> salaryList) {
        this.salaryList = salaryList;
    }
    
    
    @PostConstruct
    public void init() {
        newSalaryDetail = new SalaryDetail();

        salaryList = new ArrayList<>();
        List<Salary> sList = salaryService.listAll();
        for (Salary s : sList) {
            Department department;
            JobGrade jobGrade;
            JobLevel jobLevel;
            Position position;
            department = s.getDepartment();
            jobGrade = s.getGrade();
            jobLevel = s.getLevel();
            position = s.getPosition();
            salaryList.add(new SelectItem(s.getID(), department.getName() + " / " + position.getTitle() + " / " + jobGrade.getGrade() + " / " + jobLevel.getLevel()));
        }
    }
    
    public void btnSaveNewSalaryDetail_Handler() {
        salaryDetailService.saveNewSalaryDetail(newSalaryDetail);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salary Detail", "New salary detail is saved.");
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }
}
