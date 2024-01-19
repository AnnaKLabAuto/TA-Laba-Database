package com.solvd.training.patterns.facade;

import com.solvd.training.model.Employee;

public interface EmployeeManagementFacade {

    void createEmployee(Employee employee);

    void setSalary(Employee employee, double salary);

    void manageBenefits(Employee employee);

    void evaluatePerformance(Employee employee);
}

