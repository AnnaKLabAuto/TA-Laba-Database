package com.solvd.training.patterns.strategy;

import com.solvd.training.patterns.MockEmployeeExample;

import static com.solvd.training.utils.LoggerUtil.LOGGER;

public class StrategyMain {
    public static void main(String[] args) {

        MockEmployeeExample employee = new MockEmployeeExample("Monica", "Flower", "monica.flower@company.com", "Network Security Engineer", 6000);

        employee.setPaymentStrategy(new FixedSalary());
        LOGGER.info("Salary: " + employee.calculatePayment());

        employee.setPaymentStrategy(new ComissionBasedSalary(0.01));
        LOGGER.info("Salary: " + employee.calculatePayment());

    }
}
