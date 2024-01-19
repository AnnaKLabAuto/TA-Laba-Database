package com.solvd.training.patterns.facade;

import com.solvd.training.model.Employee;

import static com.solvd.training.utils.LoggerUtil.LOGGER;

public class EmployeeManagementFacadeImpl implements EmployeeManagementFacade {

    private Employee employee;

    public EmployeeManagementFacadeImpl(com.solvd.training.model.Employee employee) {
        this.employee = employee;
    }

    @Override
    public void createEmployee(Employee employee) {
        LOGGER.info("Employee created: " + employee.getFirstName() + employee.getLastName());
    }

    @Override
    public void setSalary(Employee employee, double salary) {
        employee.setSalary(6000);
        LOGGER.info("Salary set to " + salary + " for employee: " + employee.getFirstName() + employee.getLastName());
    }

    @Override
    public void manageBenefits(Employee employee) {
        LOGGER.info("Benefits managed for employee: " + employee.getFirstName() + employee.getLastName());
    }

    @Override
    public void evaluatePerformance(Employee employee) {
        LOGGER.info("Performance evaluated for employee: " + employee.getFirstName() + employee.getLastName());
    }
}

