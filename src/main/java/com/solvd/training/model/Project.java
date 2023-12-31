package com.solvd.training.model;

import java.util.Date;

public class Project {
    private int idProject;
    private String projectName;
    private String projectDescription;
    private Date startDate;
    private Date dueDate;
    private String priority;
    private int projectStatusesId;
    private int clientsId;
    private int projectBudgetsId;


    public Project(String projectName, String projectDescription, Date startDate, Date dueDate, String priority,
                   int projectStatusesId, int clientsId, int projectBudgetsId) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.priority = priority;
        this.projectStatusesId = projectStatusesId;
        this.clientsId = clientsId;
        this.projectBudgetsId = projectBudgetsId;
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

    public int getProjectStatusesId() {
        return projectStatusesId;
    }

    public void setProjectStatusesId(int projectStatusesId) {
        this.projectStatusesId = projectStatusesId;
    }

    public int getClientsId() {
        return clientsId;
    }

    public void setClientsId(int clientsId) {
        this.clientsId = clientsId;
    }

    public int getProjectBudgetsId() {
        return projectBudgetsId;
    }

    public void setProjectBudgetsId(int projectBudgetsId) {
        this.projectBudgetsId = projectBudgetsId;
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
                ", projectStatusesId=" + projectStatusesId +
                ", clientsId=" + clientsId +
                ", projectBudgetsId=" + projectBudgetsId +
                '}';
    }
}

