package com.solvd.training.model;

public class ProjectManagerTeamAssignment {
    private int projectManagerId;
    private int projectTeamId;
    private int projectTeamIdProjectTeam;
    private int projectManagerIdProjectManager;

    public ProjectManagerTeamAssignment(int projectManagerId, int projectTeamId,
                                        int projectTeamIdProjectTeam, int projectManagerIdProjectManager) {
        this.projectManagerId = projectManagerId;
        this.projectTeamId = projectTeamId;
        this.projectTeamIdProjectTeam = projectTeamIdProjectTeam;
        this.projectManagerIdProjectManager = projectManagerIdProjectManager;
    }

    public int getProjectManagerId() {
        return projectManagerId;
    }

    public void setProjectManagerId(int projectManagerId) {
        this.projectManagerId = projectManagerId;
    }

    public int getProjectTeamId() {
        return projectTeamId;
    }

    public void setProjectTeamId(int projectTeamId) {
        this.projectTeamId = projectTeamId;
    }

    public int getProjectTeamIdProjectTeam() {
        return projectTeamIdProjectTeam;
    }

    public void setProjectTeamIdProjectTeam(int projectTeamIdProjectTeam) {
        this.projectTeamIdProjectTeam = projectTeamIdProjectTeam;
    }

    public int getProjectManagerIdProjectManager() {
        return projectManagerIdProjectManager;
    }

    public void setProjectManagerIdProjectManager(int projectManagerIdProjectManager) {
        this.projectManagerIdProjectManager = projectManagerIdProjectManager;
    }

    @Override
    public String toString() {
        return "ProjectManagerTeamAssignment{" +
                "projectManagerId=" + projectManagerId +
                ", projectTeamId=" + projectTeamId +
                ", projectTeamIdProjectTeam=" + projectTeamIdProjectTeam +
                ", projectManagerIdProjectManager=" + projectManagerIdProjectManager +
                '}';
    }
}

