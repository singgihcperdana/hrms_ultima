/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 *
 * @author MulugetaK
 */
public class IDGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor ssci, Object o) throws HibernateException {

        //set prefix and query
        String prefix = "";
        String type = o.getClass().getName();
        String query = "";
        if (type.equalsIgnoreCase("com.dashen.hrms.Employee")) {

            prefix = "EMP_";
            query = "SELECT Employee_id_sequence.nextval from dual";
        } else if (type.equalsIgnoreCase("com.dashen.hrms.EmployeeTmp")) {

            prefix = "EMP_TMP_";
            query = "SELECT Employee_Tmp_id_sequence.nextval from dual";
        } else if (type.equalsIgnoreCase("com.dashen.hrms.Experience")) {

            prefix = "EXP_";
            query = "SELECT experience_id_sequence.nextval from dual";
        } else if (type.equalsIgnoreCase("com.dashen.hrms.JobClassification")) {

            prefix = "CLA_";
            query = "SELECT Job_Classification_id_sequence.nextval from dual";
        } else if (type.equalsIgnoreCase("com.dashen.hrms.Institution")) {

            prefix = "INS_";
            query = "SELECT Institution_id_sequence.nextval from dual";
        } else if (type.equalsIgnoreCase("com.dashen.hrms.Qualification")) {

            prefix = "QUA_";
            query = "SELECT Qualification_id_sequence.nextval from dual";
        } 
        else if (type.equalsIgnoreCase("com.dashen.hrms.QualificationTmp")) {

            prefix = "QUA_TMP_";
            query = "SELECT Qualification_tmp_id_sequence.nextval from dual";
        } 
        else if(type.equalsIgnoreCase("com.dashen.hrms.Position")) {
            prefix = "POS-";
            query = "SELECT position_id_sequence.nextval from dual";
        }
        else if(type.equalsIgnoreCase("com.dashen.hrms.JobLevel")) {
            prefix = "JOBLVL-";
            query = "SELECT job_level_id_sequence.nextval from dual";
        }
        else if (type.equalsIgnoreCase("com.dashen.hrms.Department")) {
            prefix = "DEP-";
            query = "SELECT department_id_sequence.nextval from dual";
        }
        else if (type.equalsIgnoreCase("com.dashen.hrms.JobGrade")) {
            prefix = "JOBGRD-";
            query = "SELECT job_grade_id_sequence.nextval from dual";
        }
        else if (type.equalsIgnoreCase("com.dashen.hrms.Salary")) {
            prefix = "SAL-";
            query = "SELECT salary_id_sequence.nextval from dual";
        }
        else if (type.equalsIgnoreCase("com.dashen.hrms.SalaryDetail")) {
            prefix = "SALDTL-";
            query = "SELECT salary_detail_id_sequence.nextval from dual";
        }
        else if (type.equalsIgnoreCase("com.dashen.hrms.EmployeeSalary")) {
            prefix = "EMPSAL-";
            query = "SELECT employee_salary_id_sequence.nextval from dual";
        }
        else if (type.equalsIgnoreCase("com.dashen.hrms.AllowanceType")) {
            prefix = "ALWSTYP-";
            query = "SELECT allowance_type_id_sequence.nextval from dual";
        }
        else if (type.equalsIgnoreCase("com.dashen.hrms.Allowance")) {
            prefix = "ALWS-";
            query = "SELECT allowance_id_sequence.nextval from dual";
        }
        else if (o.getClass().equals(LeaveRequest.class)) {

            prefix = "LEAVE_";
            query = "SELECT leave_request_id_sequence.nextval from dual";
        } 
        else if (o.getClass().equals(LeaveType.class)) {

            prefix = "LT";
            query = "SELECT LEAVE_TYPE_ID_SEQUENCE.nextval from dual";
        }        
        else
        {
            return null;
        }
        Connection connection = ssci.connection();

        try {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                int nextVal = rs.getInt(1);
                String generatedId = prefix + new Integer(nextVal).toString();
                System.out.println("Generated Id: " + generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
