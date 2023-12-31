package com.solvd.training.model;

public class ProjectManager {
    private int idProjectManager;
    private int projectsId;
    private int projectTeamId;

    public ProjectManager(int projectsId, int projectTeamId) {
        this.projectsId = projectsId;
        this.projectTeamId = projectTeamId;
    }

    public int getIdProjectManager() {
        return idProjectManager;
    }

    public void setIdProjectManager(int idProjectManager) {
        this.idProjectManager = idProjectManager;
    }

    public int getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(int projectsId) {
        this.projectsId = projectsId;
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
                ", projectsId=" + projectsId +
                ", projectTeamId=" + projectTeamId +
                '}';
    }
}

