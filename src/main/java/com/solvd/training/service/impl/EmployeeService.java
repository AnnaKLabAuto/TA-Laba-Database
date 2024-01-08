package com.solvd.training.service.impl;

import com.solvd.training.dao.FactoryDAO;
import com.solvd.training.dao.jdbc.JDBCFactoryDAO;
import com.solvd.training.dao.jdbc.impl.EmployeeDAO;
import com.solvd.training.dao.mybatis.MyBatisFactoryDAO;
import com.solvd.training.dao.mybatis.impl.MyBatisEmployeeDAO;
import com.solvd.training.exceptions.DuplicateEntityException;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.model.Employee;
import com.solvd.training.service.IService;

import java.util.List;

public class EmployeeService implements IService<Employee>  {

//    public final EmployeeDAO employeeDAO = new EmployeeDAO();

    private final MyBatisFactoryDAO factoryDAO = new MyBatisFactoryDAO();
    private final MyBatisEmployeeDAO employeeDAO = factoryDAO.getInstance(MyBatisEmployeeDAO.class);

    @Override
    public void create(Employee employee) throws DuplicateEntityException {
        Employee existingEmployee = employeeDAO.find(employee.getIdEmployee());
        if(existingEmployee == null){
            employeeDAO.create(employee);
        }
        throw new DuplicateEntityException("Employee exists in database");
    }

    @Override
    public void update(int id, Employee employee) throws NotFoundException {
        Employee foundEmployee = employeeDAO.find(id);
        if (foundEmployee != null) {
            employeeDAO.update(id, employee);
        } else {
            throw new NotFoundException("Can't update Employee, because it was not found");
        }
    }

    @Override
    public void delete(int id) throws NotFoundException {
        Employee foundEmployee = employeeDAO.find(id);
        if (foundEmployee != null) {
            employeeDAO.delete(id);
        } else {
            throw new NotFoundException("Can't delete Employee, because it was not found");
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

    @Override
    public List<Employee> getAll() throws NotFoundException {
        List<Employee> employees = employeeDAO.getAll();
        if (!employees.isEmpty()) {
            return employees;
        } else {
            throw new NotFoundException("No employees found");
        }
    }

}
