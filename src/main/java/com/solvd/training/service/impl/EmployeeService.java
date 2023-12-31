package com.solvd.training.service.impl;

import com.solvd.training.dao.impl.EmployeeDAO;
import com.solvd.training.exceptions.CustomException;
import com.solvd.training.model.Employee;
import com.solvd.training.service.IService;

import java.sql.SQLException;

public class EmployeeService implements IService {

    public final EmployeeDAO employeeDAO = new EmployeeDAO();

    public EmployeeService() throws CustomException {
    }

    @Override
    public void create(Employee employee) throws SQLException {
        employeeDAO.create(employee);
    }

    @Override
    public void updateById(int id, Employee employee) throws SQLException {
        employeeDAO.updateById(id, employee);
    }

    @Override
    public void deleteById(int id) throws SQLException {
        employeeDAO.deleteById(id);
    }

    @Override
    public Employee findById(int id) throws SQLException {
        return employeeDAO.findById(id);
    }
}
