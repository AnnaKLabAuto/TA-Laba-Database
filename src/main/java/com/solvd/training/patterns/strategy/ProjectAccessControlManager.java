package com.solvd.training.patterns.strategy;

import com.solvd.training.model.Employee;
import com.solvd.training.model.Project;

public class ProjectAccessControlManager {
    private AccessStrategy strategy;

    public void setStrategy(AccessStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean authenticate(Employee employee, Project project) {
        return strategy.authenticate(employee, project);
    }
}
