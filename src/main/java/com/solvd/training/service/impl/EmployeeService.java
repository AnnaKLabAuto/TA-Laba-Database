package com.solvd.training.service.impl;

import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.dao.impl.EmployeeDAO;
import com.solvd.training.model.Employee;
import com.solvd.training.service.IService;

import java.sql.SQLException;

public class EmployeeService implements IService<Employee>  {

    public final EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    public void create(Employee employee) {
        employeeDAO.create(employee);
    }

    @Override
    public void update(int id, Employee employee) {
        employeeDAO.update(id, employee);
    }

    @Override
    public void delete(int id) {
        employeeDAO.delete(id);
    }

    @Override
    public Employee find(int id) throws SQLException {
        return employeeDAO.find(id);
    }
}
