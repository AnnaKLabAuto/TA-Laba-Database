package com.solvd.training.patterns.listener;

import com.solvd.training.patterns.MockEmployeeExample;

public class EmployeeHiredEvent {

    private MockEmployeeExample employee;

    public EmployeeHiredEvent(MockEmployeeExample employee) {
        this.employee = employee;
    }

    public MockEmployeeExample getEmployee() {
        return employee;
    }
}
