/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.service;

import com.dashen.hrms.ActionType;
import com.dashen.hrms.CurrentUser;
import com.dashen.hrms.MyUser;
import com.dashen.hrms.Position;
import com.dashen.hrms.TempStatus;
import com.dashen.hrms.dao.PositionDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author biniamt
 */

@Service
public class PositionService {
    
    @Autowired
    PositionDao positionDao;


    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }
    
    @Transactional
    public boolean saveNewPosition(Position positionTmp) {
        //new Position
        Position newPosition = new Position();
        copyValuesFromTemp(newPosition, positionTmp);
        newPosition.setCreatedBy(positionTmp.getCreatedBy());
        newPosition.setCreatedDate(positionTmp.getCreatedDate());
        newPosition.setTmpStatus(TempStatus.APPROVED);
        positionDao.saveNew(newPosition);
        positionDao.delete(positionTmp);
        return true;
    }

    @Transactional
    public boolean updatePosition(Position positionTmp) {
        Position position = positionDao.getByPositionID(positionTmp.getPositionId());
        copyValuesFromTemp(position, positionTmp);
        position.setLastModifiedDate(new Date());
        position.setLastModifiedBy(positionTmp.getCreatedBy());
        positionDao.update(position);
        positionDao.delete(positionTmp);
        return true;
    }

    @Transactional
    public List<Position> listTmpPositions() {
        return positionDao.listTmpPositions();
    }
    
    public void copyValuesFromTemp(Position destPosition, Position sourcePosition)
    {
        destPosition.setID(sourcePosition.getPositionId());
        destPosition.setTitle(sourcePosition.getTitle());
    }
      
    @Transactional
    public boolean saveNewTmpPosition(Position newTmpPosition, ActionType acType) {        
        newTmpPosition.setActionType(acType);
        MyUser myUsr = CurrentUser.getCurrentUser();
        newTmpPosition.setCreatedBy(myUsr.getUsername());
        newTmpPosition.setCreatedDate(new Date());
        newTmpPosition.setTmpStatus(TempStatus.EDITABLE);
        positionDao.saveNew(newTmpPosition);
        return true;
    }
    @Transactional
    public boolean updateTmpPosition(Position tmpPosition) {       
        positionDao.update(tmpPosition);
        return true;
    }
    
    @Transactional
    public boolean delete(Position positionTmp) {
        positionDao.delete(positionTmp);
        return true;
    }
    
    public boolean checkIfPositionHasPendingEdit(String id) {
        return (positionDao.positionPendingEditCount(id) > 0);
    }
    
    @Transactional
    public List<Position> listTmpPositionsForMaker(String makerID) {
        return positionDao.listTmpPositionsForMaker(makerID);
    }
    
    @Transactional
    public List<Position> listPositions() {
        return positionDao.listPositions();
    }
    
    @Transactional
    public Position getByID(String ID) {
        return positionDao.getByID(ID);
    }
    // @Transactional
    // public boolean saveToTmpStorage(Position newPosition) {
    //     String taskJson = "";
    //     taskJson += "{title: " + newPosition.getTitle() +"}";
    // }
    
}
