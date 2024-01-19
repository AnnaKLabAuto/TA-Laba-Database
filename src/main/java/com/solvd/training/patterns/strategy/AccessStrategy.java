package com.solvd.training.patterns.strategy;

import com.solvd.training.model.Employee;
import com.solvd.training.model.Project;

public interface AccessStrategy {
    boolean authenticate(Employee employee, Project project);
}
