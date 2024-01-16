package com.solvd.training.patterns.strategy;

import com.solvd.training.patterns.MockEmployeeExample;

public class ComissionBasedSalary {

    private double commissionRate;

    public ComissionBasedSalary(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    @Override
    public double calculatePayment(MockEmployeeExample employee) {
        return employee.getSalary() * commissionRate;
    }
}
