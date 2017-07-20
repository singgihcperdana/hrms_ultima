/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author biniamt
 */

@Entity
@Table(name = "tbl_allowance")
public class Allowance {

    @Id
    @GenericGenerator(name = "idSeqGenerator", strategy = "com.dashen.hrms.IDGenerator")
    @GeneratedValue(generator = "idSeqGenerator")
    @Column(name = "ID")
    private String ID;

    @Column(name = "allowance_type_id")
    private String allowanceTypeId;
    
    @Column (name = "position_id")
    private String positionId;

    @Column(name = "value")
    private String value;
    
    @Column(name = "status")
    private String status;
    
    @Column (name = "start_date")
    private Date startDate;
    
    @Column (name ="end_date")
    private Date endDate;
    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAllowanceTypeId() {
        return allowanceTypeId;
    }

    public void setAllowanceTypeId(String allowanceTypeId) {
        this.allowanceTypeId = allowanceTypeId;
    }
    
    public String getPositionId() {
        return positionId;
    }
    
    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Allowance() {
        ID = "";
        positionId = "";
        allowanceTypeId = "";
        value = "";
        status = "";
        startDate = new Date();
        endDate = new Date();
    }
}

