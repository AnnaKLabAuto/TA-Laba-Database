package com.solvd.training.model;

public class ProjectStatus {
    private int id;
    private String projectStatusName;

    public ProjectStatus(String projectStatusName) {
        this.projectStatusName = projectStatusName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectStatusName() {
        return projectStatusName;
    }

    public void setProjectStatusName(String projectStatusName) {
        this.projectStatusName = projectStatusName;
    }

    @Override
    public String toString() {
        return "ProjectStatus{" +
                "id=" + id +
                ", projectStatusName='" + projectStatusName + '\'' +
                '}';
    }
}
