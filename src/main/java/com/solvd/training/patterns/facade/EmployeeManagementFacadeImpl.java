package com.solvd.training.patterns.facade;

import com.solvd.training.patterns.MockEmployeeExample;

import static com.solvd.training.utils.LoggerUtil.log;

public class EmployeeManagementFacadeImpl implements EmployeeManagementFacade {

    private MockEmployeeExample employee;

    public EmployeeManagementFacadeImpl(MockEmployeeExample employee) {
        this.employee = employee;
    }

    @Override
    public void createEmployee(MockEmployeeExample employee) {
        log.info("Employee created: " + employee.getFirstName() + employee.getLastName());
    }

    @Override
    public void setSalary(MockEmployeeExample employee, double salary) {
        employee.setSalary(6000);
        log.info("Salary set to " + salary + " for employee: " + employee.getFirstName() + employee.getLastName());
    }

    @Override
    public void manageBenefits(MockEmployeeExample employee) {
        log.info("Benefits managed for employee: " + employee.getFirstName() + employee.getLastName());
    }

    @Override
    public void evaluatePerformance(MockEmployeeExample employee) {
        log.info("Performance evaluated for employee: " + employee.getFirstName() + employee.getLastName());
    }
}

