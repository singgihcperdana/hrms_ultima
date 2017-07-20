package com.dashen.hrms.beans;


import com.dashen.hrms.service.LeaveService;
import com.dashen.hrms.LeaveRequest;
import com.dashen.hrms.SpringViewScope;
import com.dashen.hrms.TempStatus;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@SpringViewScope
public class DataGridViewLeave implements Serializable {
    
    private List<LeaveRequest> leaveRequests ;

     
    private LeaveRequest selectedleaveRequest;
     
    @Autowired
    LeaveService service;
 
    @PostConstruct
    public void init() {

        leaveRequests =  service.getLeaveRequest();
       
        System.out.println("HELLO HELLO0"+leaveRequests.size());
       
    }

    public List<LeaveRequest> getLeaveRequest() {
        return leaveRequests;
    }
    
    public void refresh_leave() {
        leaveRequests = service.getLeaveRequest();
        System.out.println("HELLO HELLO0"+leaveRequests.size());
    }

    public void setLeaveRequest(List<LeaveRequest> leaveRequest) {
        this.leaveRequests = leaveRequest;
    }

    public LeaveService getService() {
        return service;
    }

    public void setService(LeaveService service) {
        this.service = service;
    }

    public List<LeaveRequest> getLeaveRequests() {
        return leaveRequests;
    }

    public void setLeaveRequests(List<LeaveRequest> leaveRequests) {
        this.leaveRequests = leaveRequests;
    }

    public LeaveRequest getSelectedleaveRequest() {
        return selectedleaveRequest;
    }

    public void setSelectedleaveRequest(LeaveRequest selectedleaveRequest) {
        this.selectedleaveRequest = selectedleaveRequest;
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Record Changed", "Old Value: " + oldValue + ",The New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
     public void viewLeaveRequestDetails() {
        
        if (leaveRequests.size() < 1) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No Employee Selected", "Please select employee!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            String id = selectedleaveRequest.getLeaveID();
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("EmployeeDetails.xhtml?id=" + id);
            } catch (IOException ex) {
                //Logger.getLogger(ListAllEmployeesBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
     
      public void approveSelectedRows() {
         System.out.println("Approve");
        if (leaveRequests.size() < 1) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No rows Selected", "Please select rows!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            //approve the selected rows
            System.out.println("Approve2");
            for (LeaveRequest leave : leaveRequests) {
                System.out.println("Approve");
                if (leave.getMaker_checker_status()== TempStatus.EDITABLE) {
                   System.out.println(leave);
                   leave.setMaker_checker_status(TempStatus.SUBMITTED);
                   if(service.updateLeaveRequest(leave)){
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Approved", "LeaveRequests pending items approved.");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                   }
                } else {
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Approved Failed", "The selected row is not submitted for approval.");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            }
        }
    }

    

    
  
}