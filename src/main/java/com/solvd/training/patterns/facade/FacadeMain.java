package com.solvd.training.patterns.facade;

import com.solvd.training.patterns.MockEmployeeExample;

public class FacadeMain {
    public static void main(String[] args) {

        EmployeeManagementFacade facade = new EmployeeManagementFacadeImpl(new MockEmployeeExample("Monica", "Flower", "monica.flower@company.com", "Network Security Engineer", 9000));

        MockEmployeeExample employee = new MockEmployeeExample("Monica", "Flower", "monica.flower@company.com", "Network Security Engineer", 0);

        facade.createEmployee(employee);

        facade.setSalary(employee, 6000);

        facade.manageBenefits(employee);

        facade.evaluatePerformance(employee);
    }
}
