package com.solvd.training.model;

public class ProjectManager {
    private int idProjectManager;
    private int projectId;
    private int projectTeamId;

    public ProjectManager(int projectId, int projectTeamId) {
        this.projectId = projectId;
        this.projectTeamId = projectTeamId;
    }

    public int getIdProjectManager() {
        return idProjectManager;
    }

    public void setIdProjectManager(int idProjectManager) {
        this.idProjectManager = idProjectManager;
    }

    public int getProjectsId() {
        return projectId;
    }

    public void setProjectsId(int projectsId) {
        this.projectId = projectsId;
    }

    public int getProjectTeamId() {
        return projectTeamId;
    }

    public void setProjectTeamId(int projectTeamId) {
        this.projectTeamId = projectTeamId;
    }

    @Override
    public String toString() {
        return "ProjectManager{" +
                "idProjectManager=" + idProjectManager +
                ", projectsId=" + projectId +
                ", projectTeamId=" + projectTeamId +
                '}';
    }
}

