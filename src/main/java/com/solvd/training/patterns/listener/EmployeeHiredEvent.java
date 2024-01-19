package com.solvd.training.patterns.listener;

import com.solvd.training.model.Employee;

public class EmployeeHiredEvent {

    private Employee employee;

    public EmployeeHiredEvent(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
