/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.beans;

import com.dashen.hrms.JobLevel;
import com.dashen.hrms.service.JobLevelService;
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
public class JobLevelListBean {

    private List<JobLevel> jobLevelList;
    List<JobLevel> selectedJobLevels;

    @Autowired
    private JobLevelService jobLevelService;

    @PostConstruct
    public void init() {
        jobLevelList = jobLevelService.listAll();
    }

    public List<JobLevel> getJobLevelList() {
        return jobLevelList;
    }

    public void setJobLevelList(List<JobLevel> jobLevelList) {
        this.jobLevelList = jobLevelList;
    }

    public List<JobLevel> getSelectedJobLevels() {
        return selectedJobLevels;
    }

    public void setSelectedJobLevels(List<JobLevel> selectedJobLevels) {
        this.selectedJobLevels = selectedJobLevels;
    }
}
