package com.solvd.training.patterns.strategy;

import com.solvd.training.patterns.MockEmployeeExample;

public class StrategyMain {
    public static void main(String[] args) {
        MockEmployeeExample employee = new MockEmployeeExample("Monica", "Flower", "monica.flower@company.com", "Network Security Engineer", 0);

        employee.setPaymentStrategy(new FixedSalary());
        System.out.println("Salary: " + employee.getPayment());

        employee.setPaymentStrategy(new ComissionBasedSalary(0.1));
        System.out.println("Salary: " + employee.getPayment());

    }
}
