package com.solvd.training.patterns.strategy;

import com.solvd.training.model.Employee;
import com.solvd.training.model.Project;
import com.solvd.training.model.ProjectTeamMember;

public class ProjectAccessControlManager {
    private AccessStrategy strategy;

    public void setStrategy(AccessStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean authenticate(ProjectTeamMember projectTeamMember, Employee employee) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy is not set");
        }
        return strategy.authenticate(projectTeamMember, employee);
    }
}
