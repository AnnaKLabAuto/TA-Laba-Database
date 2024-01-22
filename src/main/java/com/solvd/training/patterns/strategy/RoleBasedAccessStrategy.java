package com.solvd.training.patterns.strategy;

import com.solvd.training.model.Employee;
import com.solvd.training.model.Project;
import com.solvd.training.model.ProjectTeamMember;

public class RoleBasedAccessStrategy implements AccessStrategy {
    @Override
    public boolean authenticate(ProjectTeamMember projectTeamMember, Employee employee) {
        String name = employee.getFirstName() + " " + employee.getLastName();
        if(projectTeamMember.getName().equals(name)){
            return true;
        }
        return false;
    }
}
