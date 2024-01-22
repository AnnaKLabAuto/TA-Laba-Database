package com.solvd.training.patterns.facade;

import com.solvd.training.model.Employee;

import static com.solvd.training.utils.LoggerUtil.LOGGER;

public class EmployeeManagementFacadeImpl implements EmployeeManagementFacade {

    private Employee employee;

    public EmployeeManagementFacadeImpl(com.solvd.training.model.Employee employee) {
        this.employee = employee;
    }


    @Override
    public void setSalary(Employee employee, double salary) {
        employee.setSalary(6000);
        LOGGER.info("Salary set to " + salary + " for employee: " + employee.getFirstName() + employee.getLastName());
    }

}

