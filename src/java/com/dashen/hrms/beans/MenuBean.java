/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.NodeUnselectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author mulugetak
 */
@Component
@SessionScope
public class MenuBean implements Serializable {

    private TreeNode root;

    @PostConstruct
    public void init() {
        root = new DefaultTreeNode(new MenuLink("/", "Menu"), null);
        TreeNode employeeProfileManageemnt = new DefaultTreeNode(new MenuLink("", "Employee Profile Management"), root);

        TreeNode node2 = new DefaultTreeNode("document", new MenuLink("/HRMS/profile/ListAllEmployees.xhtml", "List of Employees"), employeeProfileManageemnt);
        TreeNode node3 = new DefaultTreeNode("document", new MenuLink("/HRMS/profile/approve/EmployeePendingItems.xhtml", "Employee Pending Items"), employeeProfileManageemnt);
        TreeNode node5 = new DefaultTreeNode("document", new MenuLink("/HRMS/profile/edit/EditEmployees.xhtml", "Edit Employees"), employeeProfileManageemnt);
        TreeNode node6 = new DefaultTreeNode("document", new MenuLink("/HRMS/profile/approve/QualificationPendingItems.xhtml", "Qualification Pending Items"), employeeProfileManageemnt);
        
        TreeNode hrAdmin = new DefaultTreeNode(new MenuLink("", "HR Admin"), root);

        TreeNode node4 = new DefaultTreeNode("document", new MenuLink("/HRMS/hr/Institution.xhtml", "Institutions"), hrAdmin);      
        
        TreeNode leaveManagemnt = new DefaultTreeNode(new MenuLink("", "Employee Leave Management"), root);
        TreeNode node44 = new DefaultTreeNode("document", new MenuLink("/HRMS/leave/LeaveRequest.xhtml", "Requested Leaves"), leaveManagemnt);
        TreeNode node55 = new DefaultTreeNode("document", new MenuLink("/HRMS/leave/LeaveUtilized.xhtml", "Leave Utilized and Avaialble"), leaveManagemnt);
        TreeNode node66= new DefaultTreeNode("document", new MenuLink("/HRMS/leave/ListAllLeaveRequests.xhtml", "All Leave Requests "), leaveManagemnt);
        TreeNode node77 = new DefaultTreeNode("document", new MenuLink("/HRMS/leave/LeaveType.xhtml", "Manage LeaveTypes "), leaveManagemnt);
        TreeNode node88 = new DefaultTreeNode("document", new MenuLink("/HRMS/leave/approve/LeaveRequestPendingItems.xhtml", "Pending Leave Requests "), leaveManagemnt);

        TreeNode salaryTreeNode = new DefaultTreeNode(new MenuLink("", "Salary"), root);
        
        TreeNode salaryNode1 = new DefaultTreeNode("document", new MenuLink("/HRMS/salary/Department.xhtml", "Department"), salaryTreeNode);
        TreeNode salaryNode2 = new DefaultTreeNode("document", new MenuLink("/HRMS/salary/JobGradeList.xhtml", "Job Grade"), salaryTreeNode);
        TreeNode salaryNode3 = new DefaultTreeNode("document", new MenuLink("/HRMS/salary/JobLevelList.xhtml", "Job Level"), salaryTreeNode);
        TreeNode salaryNode4 = new DefaultTreeNode("document", new MenuLink("/HRMS/salary/Positions.xhtml", "Positions"), salaryTreeNode);
        TreeNode salaryNode5 = new DefaultTreeNode("document", new MenuLink("/HRMS/salary/EditPositions.xhtml", "Edit Positions"), salaryTreeNode);
        TreeNode salaryNode6 = new DefaultTreeNode("document", new MenuLink("/HRMS/salary/PositionPendingApproval.xhtml", "Position Pending Approval"), salaryTreeNode);
        TreeNode salaryNode7 = new DefaultTreeNode("document", new MenuLink("/HRMS/salary/SalaryList.xhtml", "Salary"), salaryTreeNode);
        TreeNode salaryNode8 = new DefaultTreeNode("document", new MenuLink("/HRMS/salary/SalaryDetailList.xhtml", "Salary Detail"), salaryTreeNode);
        TreeNode salaryNode9 = new DefaultTreeNode("document", new MenuLink("/HRMS/salary/EmployeeSalaryList.xhtml", "Employee Salary"), salaryTreeNode);
        TreeNode salaryNode10 = new DefaultTreeNode("document", new MenuLink("/HRMS/salary/SalaryRaise.xhtml", "Salary Raise"), salaryTreeNode);

        TreeNode allowanceTreeNode = new DefaultTreeNode(new MenuLink("", "Allowance"), root);
        
        TreeNode allowanceNode1 = new DefaultTreeNode("document", new MenuLink("/HRMS/allowance/AllowanceTypeList.xhtml", "Allowance Type"), allowanceTreeNode);
        TreeNode allowanceNode2 = new DefaultTreeNode("document", new MenuLink("/HRMS/allowance/NewAllowanceType.xhtml", "New Allowance Type"), allowanceTreeNode);
        TreeNode allowanceNode3 = new DefaultTreeNode("document", new MenuLink("/HRMS/allowance/AllowanceList.xhtml", "Allowance"), allowanceTreeNode);
        TreeNode allowanceNode4 = new DefaultTreeNode("document", new MenuLink("/HRMS/allowance/NewAllowance.xhtml", "New Allowance"), allowanceTreeNode);
    }

    public TreeNode getRoot() {
        return root;
    }

    public void onNodeSelect(NodeSelectEvent event) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(((MenuLink) event.getTreeNode().getData()).link);
        } catch (IOException ex) {
            Logger.getLogger(MenuBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onNodeUnSelect(NodeUnselectEvent event) {

    }

    public void onNodeExpand(NodeExpandEvent event) {

    }

    public void onNodeCollapse(NodeCollapseEvent event) {

    }

    public void logOut(ActionEvent actionEvent) {

        
    }

    public static class MenuLink implements Serializable {

        private String link = "";
        private String description = "";

        public MenuLink(String link, String desc) {
            this.link = link;
            this.description = desc;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
