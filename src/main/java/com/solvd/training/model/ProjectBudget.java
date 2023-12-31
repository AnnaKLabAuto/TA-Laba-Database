package com.solvd.training.model;

import java.util.Date;

public class ProjectBudget {
    private int idProjectBudgets;
    private int totalBudget;
    private Date createdAt;

    public ProjectBudget(int totalBudget, Date createdAt) {
        this.totalBudget = totalBudget;
        this.createdAt = createdAt;
    }

    public int getIdProjectBudgets() {
        return idProjectBudgets;
    }

    public void setIdProjectBudgets(int idProjectBudgets) {
        this.idProjectBudgets = idProjectBudgets;
    }

    public int getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(int totalBudget) {
        this.totalBudget = totalBudget;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ProjectBudget{" +
                "idProjectBudgets=" + idProjectBudgets +
                ", totalBudget=" + totalBudget +
                ", createdAt=" + createdAt +
                '}';
    }
}

