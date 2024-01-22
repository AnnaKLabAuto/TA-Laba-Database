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
        if (userHasPermission(employee.getIdEmployee())) {
            LOGGER.error("User don't have permission to create an employee");
            throw new UnauthorizedAccessException("User don't have permission to create an employee");
        }

        employeeService.create(employee);
        logEmployeeInformation(employee);
    }

    @Override
    public void update(int id, Employee employee) throws NotFoundException, DbAccessException, UnauthorizedAccessException {
        if (userHasPermission(employee.getIdEmployee())) {
            LOGGER.error("User don't have permission to update employee with id {}", id);
            throw new UnauthorizedAccessException("User don't have permission to update employee");
        }

        employeeService.update(id, employee);
        logEmployeeInformation(employee);
    }

    @Override
    public void delete(int id) throws NotFoundException, DbAccessException, UnauthorizedAccessException {
        if (userHasPermission(id)) {
            LOGGER.error("User don't have permission to delete employee with id {}", id);
            throw new UnauthorizedAccessException("User don't have permission to delete employee");
        }

        employeeService.delete(id);
        LOGGER.info("Employee with id {} deleted", id);
    }

    @Override
    public Employee find(int id) throws NotFoundException, DbAccessException, UnauthorizedAccessException {
        Employee employee = employeeService.find(id);
        if (userHasPermission(id)) {
            LOGGER.error("User don't have permission to read employee with id {}", id);
            throw new UnauthorizedAccessException("User don't have permission to read employee");
        }

        logEmployeeInformation(employee);
        return employee;
    }

    @Override
    public List<Employee> getAll() throws NotFoundException, DbAccessException, UnauthorizedAccessException {
        List<Employee> employees = employeeService.getAll();
        for (Employee employee : employees) {
            if (userHasPermission(employee.getIdEmployee())) {
                LOGGER.error("User don't have permission to read employee with id {}", employee.getIdEmployee());
                throw new UnauthorizedAccessException("User don't have permission to list employees");
            }
            logEmployeeInformation(employee);
        }
        return employees;
    }


    private boolean userHasPermission(int idEmployee) {
        return false;
    }

    private void logEmployeeInformation(Employee employee) {
        LOGGER.info("Employee information: " + employee.getIdEmployee());
    }
}
