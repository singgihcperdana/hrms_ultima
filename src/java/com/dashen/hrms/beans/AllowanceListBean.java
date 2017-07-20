/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.beans;

import com.dashen.hrms.Allowance;
import com.dashen.hrms.service.AllowanceService;
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
public class AllowanceListBean {

    private List<Allowance> allowanceList;
    List<Allowance> selectedAllowances;

    @Autowired
    private AllowanceService allowanceService;

    @PostConstruct
    public void init() {
        allowanceList = allowanceService.listAll();
    }

    public List<Allowance> getAllowanceList() {
        return allowanceList;
    }

    public void setAllowanceList(List<Allowance> allowanceList) {
        this.allowanceList = allowanceList;
    }

    public List<Allowance> getSelectedAllowances() {
        return selectedAllowances;
    }

    public void setSelectedAllowances(List<Allowance> selectedAllowances) {
        this.selectedAllowances = selectedAllowances;
    }
}
