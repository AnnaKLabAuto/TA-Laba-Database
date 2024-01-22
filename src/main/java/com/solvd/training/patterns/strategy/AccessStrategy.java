package com.solvd.training.patterns.strategy;

import com.solvd.training.model.Employee;
import com.solvd.training.model.Project;
import com.solvd.training.model.ProjectTeamMember;

public interface AccessStrategy {
    boolean authenticate(ProjectTeamMember projectTeamMember, Employee employee);
}
