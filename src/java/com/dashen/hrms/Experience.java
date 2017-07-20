/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms;

import javax.annotation.PostConstruct;

/**
 *
 * @author mulugetak
 */
public class Experience {
    
    private String nameOfEmployer;
    
    @PostConstruct
    public void init()
    {
        nameOfEmployer = "Comm Bank";
    }

    public String getNameOfEmployer() {
        return nameOfEmployer;
    }

    public void setNameOfEmployer(String nameOfEmployer) {
        this.nameOfEmployer = nameOfEmployer;
    }
    
    
}
