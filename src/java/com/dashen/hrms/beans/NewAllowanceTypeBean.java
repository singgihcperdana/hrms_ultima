/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.beans;

import com.dashen.hrms.AllowanceType;
import com.dashen.hrms.service.AllowanceTypeService;
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
public class NewAllowanceTypeBean {
    private AllowanceType newAllowanceType;

    @Autowired
    private AllowanceTypeService allowanceTypeService;

    public AllowanceType getNewAllowanceType() {
        return newAllowanceType;
    }

    public void setNewAllowanceType(AllowanceType newAllowanceType) {
        this.newAllowanceType = newAllowanceType;
    }

    @PostConstruct
    public void init() {
        newAllowanceType = new AllowanceType();
    }
    
    public void btnSaveNewAllowanceType_Handler() {
        allowanceTypeService.saveNewAllowanceType(newAllowanceType);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "New Allowance Type", "New allowance type is saved.");
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }
}
