/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.beans;

import com.dashen.hrms.JobGrade;
import com.dashen.hrms.service.JobGradeService;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 *
 * @author biniamt
 */


@Component
@RequestScope
public class NewJobGradeBean {
    private JobGrade newJobGrade;

    @Autowired
    private JobGradeService jobGradeService;

    public JobGrade getNewJobGrade() {
        return newJobGrade;
    }

    public void setNewJobGrade(JobGrade newJobGrade) {
        this.newJobGrade = newJobGrade;
    }

    @PostConstruct
    public void init() {
        newJobGrade = new JobGrade();
    }
    
    public void btnSaveNewJobGrade_Handler() {
        jobGradeService.saveNewJobGrade(newJobGrade);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "New Job Grade", "New job grade is saved.");
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }
}
