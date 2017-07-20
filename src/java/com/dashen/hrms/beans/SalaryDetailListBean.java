/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.beans;

import com.dashen.hrms.SalaryDetail;
import com.dashen.hrms.service.SalaryDetailService;
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
public class SalaryDetailListBean {

    private List<SalaryDetail> salaryDetailList;
    List<SalaryDetail> selectedSalaryDetails;

    @Autowired
    private SalaryDetailService salaryDetailService;

    @PostConstruct
    public void init() {
        salaryDetailList = salaryDetailService.listAll();
    }

    public List<SalaryDetail> getSalaryDetailList() {
        return salaryDetailList;
    }

    public void setSalaryDetailList(List<SalaryDetail> salaryDetailList) {
        this.salaryDetailList = salaryDetailList;
    }

    public List<SalaryDetail> getSelectedSalaryDetails() {
        return selectedSalaryDetails;
    }

    public void setSelectedSalaryDetails(List<SalaryDetail> selectedSalaryDetails) {
        this.selectedSalaryDetails = selectedSalaryDetails;
    }
}