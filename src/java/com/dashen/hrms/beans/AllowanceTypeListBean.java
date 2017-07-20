/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.beans;

import com.dashen.hrms.AllowanceType;
import com.dashen.hrms.service.AllowanceTypeService;
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
public class AllowanceTypeListBean {

    private List<AllowanceType> allowanceTypeList;
    List<AllowanceType> selectedAllowanceTypes;

    @Autowired
    private AllowanceTypeService allowanceTypeService;

    @PostConstruct
    public void init() {
        allowanceTypeList = allowanceTypeService.listAll();
    }

    public List<AllowanceType> getAllowanceTypeList() {
        return allowanceTypeList;
    }

    public void setAllowanceTypeList(List<AllowanceType> allowanceTypeList) {
        this.allowanceTypeList = allowanceTypeList;
    }

    public List<AllowanceType> getSelectedAllowanceTypes() {
        return selectedAllowanceTypes;
    }

    public void setSelectedAllowanceTypes(List<AllowanceType> selectedAllowanceTypes) {
        this.selectedAllowanceTypes = selectedAllowanceTypes;
    }
}