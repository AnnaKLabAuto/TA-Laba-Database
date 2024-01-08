package com.solvd.training.model;

import java.util.Date;

public class ProjectAssignment {
    private int idProjectAssignments;
    private Date startDate;
    private Date endDate;
    private int employeeId;
    private int projectId;
    private int taskId;

    public ProjectAssignment(Date startDate, Date endDate, int employeeId,
                             int projectId, int taskId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.taskId = taskId;
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getTasksId() {
        return taskId;
    }

    public void setTasksId(int tasksId) {
        this.taskId = tasksId;
    }

    @Override
    public String toString() {
        return "ProjectAssignment{" +
                "idProjectAssignments=" + idProjectAssignments +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", employeeId=" + employeeId +
                ", projectId=" + projectId +
                ", taskId=" + taskId +
                '}';
    }
}

