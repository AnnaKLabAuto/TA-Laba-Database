package com.solvd.training.patterns.strategy;

import com.solvd.training.model.Employee;
import com.solvd.training.model.Project;
import com.solvd.training.model.ProjectTeamMember;

public class PermissionBasedAccessStrategy implements AccessStrategy {
    @Override
    public boolean authenticate(ProjectTeamMember projectTeamMember, Employee employee) {
        if (employee.getDepartmentId() == 1) {
            return true;
        } else {
            return false ;
        }
    }
}
