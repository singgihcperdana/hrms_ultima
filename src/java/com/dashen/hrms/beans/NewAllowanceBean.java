/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.beans;

import com.dashen.hrms.Allowance;
import com.dashen.hrms.AllowanceType;
import com.dashen.hrms.Position;
import com.dashen.hrms.service.AllowanceService;
import com.dashen.hrms.service.AllowanceTypeService;
import com.dashen.hrms.service.PositionService;
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
public class NewAllowanceBean {
    private Allowance newAllowance;

    @Autowired
    private AllowanceService allowanceService;
    @Autowired
    private AllowanceTypeService allowanceTypeService;
    @Autowired
    private PositionService positionService;
    
    private List<SelectItem> allowanceTypeList;
    private List<SelectItem> positionList;

    public Allowance getNewAllowance() {
        return newAllowance;
    }

    public void setNewAllowance(Allowance newAllowance) {
        this.newAllowance = newAllowance;
    }

    public List<SelectItem> getAllowanceTypeList() {
        return allowanceTypeList;
    }

    public void setAllowanceTypeList(List<SelectItem> allowanceTypeList) {
        this.allowanceTypeList = allowanceTypeList;
    }
    
    public List<SelectItem> getPositionList() {
        return positionList;
    }
    
    public void setPositionList(List<SelectItem> positionList) {
        this.positionList = positionList;
    }

    @PostConstruct
    public void init() {
        newAllowance = new Allowance();
        
        allowanceTypeList = new ArrayList<>();
        positionList = new ArrayList<>();
        
        List<AllowanceType> atList = allowanceTypeService.listAll();
        for (AllowanceType at : atList) {
            allowanceTypeList.add(new SelectItem(at.getID(), at.getDescription() + " (in " + at.getMeasurementUnit() + ")"));
        }
        
        List<Position> pList = positionService.listPositions();
        for (Position p : pList) {
            positionList.add(new SelectItem(p.getID(), p.getTitle()));
        }
    }
    
    public void btnSaveNewAllowance_Handler() {
        allowanceService.saveNewAllowance(newAllowance);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "New Allowance", "New allowance is saved.");
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }
}
