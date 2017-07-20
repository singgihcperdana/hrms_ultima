/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.beans;

import com.dashen.hrms.JobGrade;
import com.dashen.hrms.service.JobGradeService;
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
public class JobGradeListBean {

    private List<JobGrade> jobGradeList;
    List<JobGrade> selectedJobGrades;

    @Autowired
    private JobGradeService jobGradeService;

    @PostConstruct
    public void init() {
        jobGradeList = jobGradeService.listAll();
    }

    public List<JobGrade> getJobGradeList() {
        return jobGradeList;
    }

    public void setJobGradeList(List<JobGrade> jobGradeList) {
        this.jobGradeList = jobGradeList;
    }

    public List<JobGrade> getSelectedJobGrades() {
        return selectedJobGrades;
    }

    public void setSelectedJobGrades(List<JobGrade> selectedJobGrades) {
        this.selectedJobGrades = selectedJobGrades;
    }
}
