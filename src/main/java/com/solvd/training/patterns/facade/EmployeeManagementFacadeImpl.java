package com.solvd.training.patterns.facade;

import com.solvd.training.patterns.MockEmployeeExample;

import static com.solvd.training.utils.LoggerUtil.LOGGER;

public class EmployeeManagementFacadeImpl implements EmployeeManagementFacade {

    private MockEmployeeExample employee;

    public EmployeeManagementFacadeImpl(MockEmployeeExample employee) {
        this.employee = employee;
    }

    @Override
    public void createEmployee(MockEmployeeExample employee) {
        LOGGER.info("Employee created: " + employee.getFirstName() + employee.getLastName());
    }

    @Override
    public void setSalary(MockEmployeeExample employee, double salary) {
        employee.setSalary(6000);
        LOGGER.info("Salary set to " + salary + " for employee: " + employee.getFirstName() + employee.getLastName());
    }

    @Override
    public void manageBenefits(MockEmployeeExample employee) {
        LOGGER.info("Benefits managed for employee: " + employee.getFirstName() + employee.getLastName());
    }

    @Override
    public void evaluatePerformance(MockEmployeeExample employee) {
        LOGGER.info("Performance evaluated for employee: " + employee.getFirstName() + employee.getLastName());
    }
}

