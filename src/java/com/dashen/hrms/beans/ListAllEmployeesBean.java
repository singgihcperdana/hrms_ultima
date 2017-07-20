/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.beans;

import com.dashen.hrms.Employee;
import com.dashen.hrms.service.EmployeeService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 *
 * @author mulugetak
 */
@Component
@RequestScope
public class ListAllEmployeesBean {

    private List<Employee> employeesList;
    private List<Employee> selectedEmployees;

    @Autowired
    private EmployeeService empService;

    @PostConstruct
    public void init() {
        employeesList = empService.listAll();

    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employee> employeesList) {
        this.employeesList = employeesList;
    }

    public List<Employee> getSelectedEmployees() {
        return selectedEmployees;
    }

    public void setSelectedEmployees(List<Employee> selectedEmployees) {
        this.selectedEmployees = selectedEmployees;
    }

    public void newEmployee() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HRMS/profile/edit/EditEmployees.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void changeProfilePhoto() {
        if (selectedEmployees.size() < 1) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No Employee Selected", "Please select employee!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            String id = selectedEmployees.get(0).getEmployeeSerialID();
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("ChangeProfilePhoto.xhtml?id=" + id);
            } catch (IOException ex) {
                Logger.getLogger(ListAllEmployeesBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void viewEmployeeDetails() {
        if (selectedEmployees.size() < 1) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No Employee Selected", "Please select employee!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            String id = selectedEmployees.get(0).getEmployeeSerialID();
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("EmployeeDetails.xhtml?id=" + id);
            } catch (IOException ex) {
                Logger.getLogger(ListAllEmployeesBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void addEmployeeQualification() {
        if (selectedEmployees.size() < 1) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No Employee Selected", "Please select employee!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
//            String id = selectedEmployees.get(0).getEmployeeSerialID();
//            try {
//                
//            } catch (IOException ex) {
//                Logger.getLogger(ListAllEmployeesBean.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
    }

    public void viewEmployeeQualification() {
        if (selectedEmployees.size() < 1) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No Employee Selected", "Please select employee!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
//            String id = selectedEmployees.get(0).getEmployeeSerialID();
//            try {
//                
//            } catch (IOException ex) {
//                Logger.getLogger(ListAllEmployeesBean.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
    }

    public void addEmployeeExperience() {
        if (selectedEmployees.size() < 1) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No Employee Selected", "Please select employee!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
//            String id = selectedEmployees.get(0).getEmployeeSerialID();
//            try {
//                
//            } catch (IOException ex) {
//                Logger.getLogger(ListAllEmployeesBean.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
    }

    public void viewEmployeeExperience() {
        if (selectedEmployees.size() < 1) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No Employee Selected", "Please select employee!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
//            String id = selectedEmployees.get(0).getEmployeeSerialID();
//            try {
//                
//            } catch (IOException ex) {
//                Logger.getLogger(ListAllEmployeesBean.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
    }

    public void addEmployeeTraining() {
        if (selectedEmployees.size() < 1) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No Employee Selected", "Please select employee!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
//            String id = selectedEmployees.get(0).getEmployeeSerialID();
//            try {
//                
//            } catch (IOException ex) {
//                Logger.getLogger(ListAllEmployeesBean.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
    }

    public void viewEmployeeTraining() {
        if (selectedEmployees.size() < 1) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No Employee Selected", "Please select employee!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
//            String id = selectedEmployees.get(0).getEmployeeSerialID();
//            try {
//                
//            } catch (IOException ex) {
//                Logger.getLogger(ListAllEmployeesBean.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
    }

    public void addEmployeeReferee() {
        if (selectedEmployees.size() < 1) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No Employee Selected", "Please select employee!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
//            String id = selectedEmployees.get(0).getEmployeeSerialID();
//            try {
//                
//            } catch (IOException ex) {
//                Logger.getLogger(ListAllEmployeesBean.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
    }

    public void viewEmployeeReferee() {
        if (selectedEmployees.size() < 1) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No Employee Selected", "Please select employee!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
//            String id = selectedEmployees.get(0).getEmployeeSerialID();
//            try {
//                
//            } catch (IOException ex) {
//                Logger.getLogger(ListAllEmployeesBean.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
    }

    public void addEmployeeReference() {
        if (selectedEmployees.size() < 1) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No Employee Selected", "Please select employee!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
//            String id = selectedEmployees.get(0).getEmployeeSerialID();
//            try {
//                
//            } catch (IOException ex) {
//                Logger.getLogger(ListAllEmployeesBean.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
    }

    public void viewEmployeeReference() {
        if (selectedEmployees.size() < 1) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No Employee Selected", "Please select employee!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
//            String id = selectedEmployees.get(0).getEmployeeSerialID();
//            try {
//                
//            } catch (IOException ex) {
//                Logger.getLogger(ListAllEmployeesBean.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
    }

}
