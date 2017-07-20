/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 *
 * @author mulugetak
 */
@Component
@ApplicationScope
public class Configuration {
    public static String PROFILE_PHOTO_PATH = "/images/profile/";
    public static String QUALIFICATION_DOCUMENTS_PATH = "/images/qualification/";
    public static String EXPERIENCE_DOCUMENTS_PATH = "/images/experience/";
    
    public String getPROFILE_PHOTO_PATH()
    {
        return PROFILE_PHOTO_PATH;
    }
    
    public String getQUALIFICATION_DOCUMENTS_PATH()
    {
        return QUALIFICATION_DOCUMENTS_PATH;
    }
    public String getEXPERIENCE_DOCUMENTS_PATH()
    {
        return EXPERIENCE_DOCUMENTS_PATH;
    }
}
