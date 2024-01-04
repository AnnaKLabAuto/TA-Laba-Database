package com.solvd.training.service.impl;

import com.solvd.training.dao.impl.EmployeeDAO;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.model.Department;
import com.solvd.training.model.Employee;
import com.solvd.training.service.IService;

public class EmployeeService implements IService<Employee>  {

    public final EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    public void create(Employee employee) {
        employeeDAO.create(employee);
    }

    @Override
    public void update(int id, Employee employee) throws NotFoundException {
        Employee foundEmployee = employeeDAO.find(id);
        if (foundEmployee != null) {
            employeeDAO.update(id, employee);
        } else {
            throw new NotFoundException("Employee was not found");
        }
    }

    @Override
    public void delete(int id) throws NotFoundException {
        Employee foundEmployee = employeeDAO.find(id);
        if (foundEmployee != null) {
            employeeDAO.delete(id);
        } else {
            throw new NotFoundException("Employee was not found");
        }
    }

    @Override
    public Employee find(int id) throws NotFoundException {
        Employee employee = employeeDAO.find(id);
        if (employee != null) {
            return employee;
        } else {
            throw new NotFoundException("Employee was not found");
        }
    }
}
