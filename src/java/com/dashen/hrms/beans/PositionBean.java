/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.beans;

import com.dashen.hrms.ActionType;
import com.dashen.hrms.CurrentUser;
import com.dashen.hrms.MyUser;
import com.dashen.hrms.Position;
import com.dashen.hrms.SpringViewScope;
import com.dashen.hrms.TempStatus;
import com.dashen.hrms.service.PositionService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author biniamt
 */

@Component
@SpringViewScope
public class PositionBean implements Serializable {

    private Position currentTempPosition;

    @Autowired
    private PositionService positionService;

    private List<Position> positionsList;
    private Position selectedPosition;

    private List<Position> tempPositionsList;
    private Position selectedTempPosition;

    public Position getCurrentTempPosition() {
        return currentTempPosition;
    }


    public void setCurrentTempPosition(Position currentTempPosition) {
        this.currentTempPosition = currentTempPosition;
    }

    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }

    public List<Position> getPositionsList() {
        return positionsList;
    }

    public void setPositionsList(List<Position> positionsList) {
        this.positionsList = positionsList;
    }

    public Position getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(Position selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    public List<Position> getTempPositionsList() {
        return tempPositionsList;
    }

    public void setTempPositionsList(List<Position> tempPositionsList) {
        this.tempPositionsList = tempPositionsList;
    }

    public Position getSelectedTempPosition() {
        return selectedTempPosition;
    }

    public void setSelectedTempPosition(Position selectedTempPosition) {
        this.selectedTempPosition = selectedTempPosition;
    }

    @PostConstruct
    public void init() {

        currentTempPosition = new Position();

        positionsList = positionService.listPositions();
        tempPositionsList = new ArrayList<>();
    }

    public void btnNewPosition_Handler() {
        currentTempPosition = new Position();
    }

    public boolean isRowSubmitted() {
        if (currentTempPosition != null && currentTempPosition.getTmpStatus() == TempStatus.EDITABLE) {
            return false;
        }
        return true;
    }
    public void btnRefreshList_Handler() {
        MyUser user = CurrentUser.getCurrentUser();
        tempPositionsList = positionService.listTmpPositionsForMaker(user.getUsername());
    }

    public void tmpPositionsDataTableDataTable_rowSelected(SelectEvent evt) {
        currentTempPosition = selectedTempPosition;
    }

    public void btnSavePosition_Handler() {
        if (currentTempPosition.getTmpStatus() == TempStatus.EDITABLE) {
            if (currentTempPosition.getID() != null && !currentTempPosition.getID().isEmpty()) {
                //is updating existing Temp Position record
                if (positionService.updateTmpPosition(currentTempPosition)) {
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Position update", "Position updates saved.");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Position update", "Update Failed.");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else if (currentTempPosition.getPositionId() != null && !currentTempPosition.getPositionId().isEmpty()) {//editing existing Position, tmp object is new
                if (positionService.saveNewTmpPosition(currentTempPosition, ActionType.UPDATE)) {
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Position update", "Position updates saved.");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Position update", "Update Failed.");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else//new position, and new tmp object
            {
                if (positionService.saveNewTmpPosition(currentTempPosition, ActionType.CREATE)) {
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "New Position", "New Position added.");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "New Position", "Save Failed.");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            }
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Update Position", "The selected row is already submitted.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        currentTempPosition = new Position();
    }

    public void btnSubmit_Handler() {
        if (selectedTempPosition != null) {
            if (selectedTempPosition.getTmpStatus() != TempStatus.SUBMITTED) {
                selectedTempPosition.setTmpStatus(TempStatus.SUBMITTED);
                if (positionService.updateTmpPosition(selectedTempPosition)) {
                    //update successful   
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Submit Row", "Row submitted.");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    //update has failed, undo the change
                    selectedTempPosition.setTmpStatus(TempStatus.EDITABLE);
                }
            } else {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Submit Row", "The selected row is already submitted.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Submit Row", "No row selected.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void btnDeleteRow_Handler() {
        if (selectedTempPosition != null) {
            if (selectedTempPosition.getTmpStatus() != TempStatus.SUBMITTED) {
                if (positionService.delete(selectedTempPosition)) {
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete Row", "Row is deleted.");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                    currentTempPosition = new Position();
                    tempPositionsList.remove(selectedTempPosition);
                } else {
                    //delete failed
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Delete Row", "Row is not deleted.");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Delete Row", "Submitted rows cannot be deleted.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete Row", "No row selected.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void btnEditSelectedPosition_Handler() {
        Position positionTmp = new Position();
        if (selectedPosition != null) {
            if (!positionService.checkIfPositionHasPendingEdit(selectedPosition.getID())) {
                positionTmp.setPositionId(selectedPosition.getID());
                positionTmp.setTitle(selectedPosition.getTitle());
                currentTempPosition = positionTmp;
            } else {
                System.out.println("Position has pending changes");
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Edit Position", "The selected position has pending changes. Please approve or cancel the changes and try again.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }
}
