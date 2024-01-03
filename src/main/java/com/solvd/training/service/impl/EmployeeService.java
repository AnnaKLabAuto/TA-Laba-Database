package com.solvd.training.service.impl;

import com.solvd.training.dao.impl.EmployeeDAO;
import com.solvd.training.model.Employee;
import com.solvd.training.service.IService;

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
    public Employee find(int id){
        return employeeDAO.find(id);
    }
}
