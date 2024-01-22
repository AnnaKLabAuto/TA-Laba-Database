package com.solvd.training.patterns.strategy;

import com.solvd.training.model.Employee;
import com.solvd.training.model.ProjectTeamMember;

public class DepartmentBasedAccessStrategy implements AccessStrategy {
    @Override
    public boolean authenticate(ProjectTeamMember projectTeamMember, Employee employee) {
        if (employee.getDepartmentId() == 1) {
            return true;
        } else {
            return false ;
        }
    }
}
