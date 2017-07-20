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
import com.dashen.hrms.service.DepartmentService;
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
public class NewSalaryBean {
    private Salary newSalary;

    @Autowired
    private SalaryService salaryService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private JobGradeService jobGradeService;
    @Autowired
    private JobLevelService jobLevelService;
    @Autowired
    private PositionService positionService;

    private List<SelectItem> departmentList;
    private List<SelectItem> jobGradeList;
    private List<SelectItem> jobLevelList;
    private List<SelectItem> positionList;

    public Salary getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(Salary newSalary) {
        this.newSalary = newSalary;
    }

    public List<SelectItem> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<SelectItem> departmentList) {
        this.departmentList = departmentList;
    }

    public List<SelectItem> getJobGradeList() {
        return jobGradeList;
    }

    public void setJobGradeList(List<SelectItem> jobGradeList) {
        this.jobGradeList = jobGradeList;
    }

    public List<SelectItem> getJobLevelList() {
        return jobLevelList;
    }

    public void setJobLevelList(List<SelectItem> jobLevelList) {
        this.jobLevelList = jobLevelList;
    }

    public List<SelectItem> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<SelectItem> positionList) {
        this.positionList = positionList;
    }    
    

    @PostConstruct
    public void init() {
        newSalary = new Salary();
        departmentList = new ArrayList<>();
        jobGradeList = new ArrayList<>();
        jobLevelList = new ArrayList<>();
        positionList = new ArrayList<>();
        List<Department> dList = departmentService.listAll();
        for (Department d : dList) {
            departmentList.add(new SelectItem(d.getID(), d.getName()));
        }
        
        List<JobGrade> jList = jobGradeService.listAll();
        for (JobGrade j : jList) {
            jobGradeList.add(new SelectItem(j.getID(), j.getGrade()));
        }
        
        List<Position> pList = positionService.listPositions();
        for (Position p : pList) {
            positionList.add(new SelectItem(p.getID(), p.getTitle()));
        }
        
        List<JobLevel> lList = jobLevelService.listAll();
        for (JobLevel l : lList) {
            jobLevelList.add(new SelectItem(l.getID(), l.getLevel()));
        }
    }
    
    public void btnSaveNewSalary_Handler() {
        salaryService.saveNewSalary(newSalary);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "New Salary", "New salary is saved.");
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }
}
