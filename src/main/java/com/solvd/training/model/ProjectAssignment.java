package com.solvd.training.model;

import java.util.Date;

public class ProjectAssignment {
    private int idProjectAssignments;
    private Date startDate;
    private Date endDate;
    private int employeesId;
    private int projectsId;
    private int tasksIdTask;


    public ProjectAssignment(Date startDate, Date endDate, int employeesId,
                             int projectsId, int tasksIdTask) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeesId = employeesId;
        this.projectsId = projectsId;
        this.tasksIdTask = tasksIdTask;
    }

    public int getIdProjectAssignments() {
        return idProjectAssignments;
    }

    public void setIdProjectAssignments(int idProjectAssignments) {
        this.idProjectAssignments = idProjectAssignments;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(int employeesId) {
        this.employeesId = employeesId;
    }

    public int getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(int projectsId) {
        this.projectsId = projectsId;
    }

    public int getTasksIdTask() {
        return tasksIdTask;
    }

    public void setTasksIdTask(int tasksIdTask) {
        this.tasksIdTask = tasksIdTask;
    }

    @Override
    public String toString() {
        return "ProjectAssignment{" +
                "idProjectAssignments=" + idProjectAssignments +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", employeesId=" + employeesId +
                ", projectsId=" + projectsId +
                ", tasksIdTask=" + tasksIdTask +
                '}';
    }
}

