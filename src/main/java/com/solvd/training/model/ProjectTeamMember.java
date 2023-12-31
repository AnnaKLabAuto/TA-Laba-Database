package com.solvd.training.model;

public class ProjectTeamMember {
    private int idProjectTeam;
    private String role;
    private String name;
    private String responsibilities;

    public ProjectTeamMember(String role, String name, String responsibilities) {
        this.role = role;
        this.name = name;
        this.responsibilities = responsibilities;
    }

    public int getIdProjectTeam() {
        return idProjectTeam;
    }

    public void setIdProjectTeam(int idProjectTeam) {
        this.idProjectTeam = idProjectTeam;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    @Override
    public String toString() {
        return "ProjectTeamMember{" +
                "idProjectTeam=" + idProjectTeam +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", responsibilities='" + responsibilities + '\'' +
                '}';
    }
}

