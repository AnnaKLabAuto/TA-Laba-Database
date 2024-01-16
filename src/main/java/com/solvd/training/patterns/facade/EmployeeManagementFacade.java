package com.solvd.training.patterns.facade;

import com.solvd.training.patterns.MockEmployeeExample;

public interface EmployeeManagementFacade {

    void createEmployee(MockEmployeeExample employee);

    void setSalary(MockEmployeeExample employee, double salary);

    void manageBenefits(MockEmployeeExample employee);

    void evaluatePerformance(MockEmployeeExample employee);
}

