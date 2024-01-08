package com.solvd.training.model;

import java.util.Date;

public class Project {
    private int idProject;
    private String projectName;
    private String projectDescription;
    private Date startDate;
    private Date dueDate;
    private String priority;
    private int projectStatusId;
    private int clientId;
    private int projectBudgetId;


    public Project(String projectName, String projectDescription, Date startDate, Date dueDate, String priority,
                   int projectStatusId, int clientId, int projectBudgetId) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.priority = priority;
        this.projectStatusId = projectStatusId;
        this.clientId = clientId;
        this.projectBudgetId = projectBudgetId;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getProjectStatusId() {
        return projectStatusId;
    }

    public void setProjectStatusId(int projectStatusId) {
        this.projectStatusId = projectStatusId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getProjectBudgetId() {
        return projectBudgetId;
    }

    public void setProjectBudgetId(int projectBudgetId) {
        this.projectBudgetId = projectBudgetId;
    }

    @Override
    public String toString() {
        return "Project{" +
                "idProject=" + idProject +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", startDate=" + startDate +
                ", dueDate=" + dueDate +
                ", priority='" + priority + '\'' +
                ", projectStatusId=" + projectStatusId +
                ", clientId=" + clientId +
                ", projectBudgetId=" + projectBudgetId +
                '}';
    }
}

