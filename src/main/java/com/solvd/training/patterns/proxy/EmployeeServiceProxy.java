package com.solvd.training.patterns.proxy;

import com.solvd.training.exceptions.DbAccessException;
import com.solvd.training.exceptions.DuplicateEntityException;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.exceptions.UnauthorizedAccessException;
import com.solvd.training.model.Employee;
import com.solvd.training.service.IService;
import com.solvd.training.service.impl.EmployeeService;

import static com.solvd.training.utils.LoggerUtil.LOGGER;

import java.util.List;

public class EmployeeServiceProxy implements IService<Employee> {

    private final EmployeeService employeeService;

    public EmployeeServiceProxy(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void create(Employee employee) throws DuplicateEntityException, DbAccessException, UnauthorizedAccessException {
        if (!userHasPermissionToCreate(employee)) {
            LOGGER.error("User don't have permission to create an employee");
            throw new UnauthorizedAccessException("User don't have permission to create an employee");
        }
        employeeService.create(employee);
        logEmployeeInformation(employee);
    }

    @Override
    public void update(int id, Employee employee) throws NotFoundException, DbAccessException {
        employeeService.update(id, employee);
    }

    @Override
    public void delete(int id) throws NotFoundException, DbAccessException {
        employeeService.delete(id);
    }

    @Override
    public Employee find(int id) throws NotFoundException, DbAccessException {
        Employee employee = employeeService.find(id);
        logEmployeeInformation(employee);
        return employee;
    }

    @Override
    public List<Employee> getAll() throws NotFoundException, DbAccessException {
        List<Employee> employees = employeeService.getAll();
        for (Employee employee : employees) {
            logEmployeeInformation(employee);
        }
        return employees;
    }

    private boolean userHasPermissionToCreate(Employee employee) {
        return true;
    }

    private void logEmployeeInformation(Employee employee) {
        LOGGER.info("Employee information: " + employee.getIdEmployee());
    }
}
