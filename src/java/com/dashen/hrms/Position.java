/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 *
 * @author biniamt
 */

@Entity
@Table(name = "tbl_position")
public class Position implements Serializable {

    @Id
    @GenericGenerator(name = "idSeqGenerator", strategy = "com.dashen.hrms.IDGenerator")
    @GeneratedValue(generator = "idSeqGenerator")
    @Column(name = "ID")
    private String ID;

    @Column(name = "TITLE")
    private String title;
    
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    @Column(name = "approved_by")
    private String approvedBy;

    @Column(name = "approved_date")
    private Date approvedDate;

    @Column(name = "position_id")
    private String positionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "action_type")
    private ActionType actionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "tmp_status")
    private TempStatus tmpStatus;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

   public String getCreatedBy() {
       return createdBy;
   }

   public void setCreatedBy(String createdBy) {
       this.createdBy = createdBy;
   }

   public Date getCreatedDate() {
       return createdDate;
   }

   public void setCreatedDate(Date createdDate) {
       this.createdDate = createdDate;
   }

   public String getLastModifiedBy() {
       return lastModifiedBy;
   }

   public void setLastModifiedBy(String lastModifiedBy) {
       this.lastModifiedBy = lastModifiedBy;
   }

   public Date getLastModifiedDate() {
       return lastModifiedDate;
   }

   public void setLastModifiedDate(Date lastModifiedDate) {
       this.lastModifiedDate = lastModifiedDate;
   }

   public String getApprovedBy() {
       return approvedBy;
   }

   public void setApprovedBy(String approvedBy) {
       this.approvedBy = approvedBy;
   }

   public Date getApprovedDate() {
       return approvedDate;
   }

   public void setApprovedDate(Date approvedDate) {
       this.approvedDate = approvedDate;
   }

   public String getPositionId() {
       return positionId;
   }

   public void setPositionId(String positionId) {
       this.positionId = positionId;
   }

   public ActionType getActionType() {
       return actionType;
   }

   public void setActionType(ActionType actionType) {
       this.actionType = actionType;
   }

   public TempStatus getTmpStatus() {
       return tmpStatus;
   }

   public void setTmpStatus(TempStatus tmpStatus) {
       this.tmpStatus = tmpStatus;
   }

    public Position() {
        ID = "";
        title = "";
        createdBy = "";
        createdDate = new Date();
        lastModifiedBy = "";
        lastModifiedDate = new Date();
        approvedBy = "";
        approvedDate = new Date();
        positionId = "";
        actionType = ActionType.CREATE;
        tmpStatus = TempStatus.EDITABLE;
    }
}
