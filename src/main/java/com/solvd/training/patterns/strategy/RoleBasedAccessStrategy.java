package com.solvd.training.patterns.strategy;

import com.solvd.training.model.Employee;
import com.solvd.training.model.Project;

public class RoleBasedAccessStrategy implements AccessStrategy {
    @Override
    public boolean authenticate(Employee employee, Project project) {
        if (employee.getDepartmentId() == 1) { // means that employee is in IT department
            return true;
        } else {
            return false ;
        }
    }
}
