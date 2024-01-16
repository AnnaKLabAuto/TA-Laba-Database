package com.solvd.training.patterns.strategy;

import com.solvd.training.patterns.MockEmployeeExample;

public class FixedSalary implements Payment{
    @Override
    public double calculatePayment(MockEmployeeExample employee) {
        return employee.getSalary();
    }
}
