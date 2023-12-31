package com.solvd.training.model;

public class EmploymentStatus {
    private int idEmploymentStatus;
    private String employmentStatusName;

    public EmploymentStatus(String employmentStatusName) {
        this.employmentStatusName = employmentStatusName;
    }

    public int getIdEmploymentStatus() {
        return idEmploymentStatus;
    }

    public void setIdEmploymentStatus(int idEmploymentStatus) {
        this.idEmploymentStatus = idEmploymentStatus;
    }

    public String getEmploymentStatusName() {
        return employmentStatusName;
    }

    public void setEmploymentStatusName(String employmentStatusName) {
        this.employmentStatusName = employmentStatusName;
    }

    @Override
    public String toString() {
        return "EmploymentStatus{" +
                "idEmploymentStatus=" + idEmploymentStatus +
                ", employmentStatusName='" + employmentStatusName + '\'' +
                '}';
    }
}
