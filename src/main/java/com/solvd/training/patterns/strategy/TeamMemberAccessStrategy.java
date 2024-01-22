package com.solvd.training.patterns.strategy;

import com.solvd.training.model.Employee;
import com.solvd.training.model.ProjectTeamMember;

public class TeamMemberAccessStrategy implements AccessStrategy {
    @Override
    public boolean authenticate(ProjectTeamMember projectTeamMember, Employee employee) {
        String name = employee.getFirstName() + " " + employee.getLastName();
        if(projectTeamMember.getName().equals(name)){
            return true;
        } else {
            return false;
        }
    }
}
