package com.solvd.training.service.impl;

import com.solvd.training.dao.FactoryDAO;
import com.solvd.training.dao.IBaseDAO;
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

    private final IBaseDAO<Employee> daoInstance;

    public EmployeeService(String choosedAcessDataType) {
        FactoryDAO<IBaseDAO<Employee>, Employee> factoryDAO;
        if ("MY_BATIS".equals(choosedAcessDataType)) {
            factoryDAO = new MyBatisFactoryDAO(MyBatisEmployeeDAO.class);
        } else if ("JDBC".equals(choosedAcessDataType)) {
            factoryDAO = new JDBCFactoryDAO(EmployeeDAO.class);
        } else {
            throw new IllegalArgumentException("Invalid data access type");
        }
        this.daoInstance = factoryDAO.getInstance();
    }

    @Override
    public void create(Employee employee) throws DuplicateEntityException {
        Employee existingEmployee = daoInstance.find(employee.getIdEmployee());
        if(existingEmployee == null){
            daoInstance.create(employee);
        } else{
            throw new DuplicateEntityException("Employee exists in database");
        }
    }

    @Override
    public void update(int id, Employee employee) throws NotFoundException {
        Employee foundEmployee = daoInstance.find(id);
        if (foundEmployee != null) {
            daoInstance.update(id, employee);
        } else {
            throw new NotFoundException("Can't update Employee, because it was not found");
        }
    }

    @Override
    public void delete(int id) throws NotFoundException {
        Employee foundEmployee = daoInstance.find(id);
        if (foundEmployee != null) {
            daoInstance.delete(id);
        } else {
            throw new NotFoundException("Can't delete Employee, because it was not found");
        }
    }

    @Override
    public Employee find(int id) throws NotFoundException {
        Employee employee = daoInstance.find(id);
        if (employee != null) {
            return employee;
        } else {
            throw new NotFoundException("Employee was not found");
        }
    }

    @Override
    public List<Employee> getAll() throws NotFoundException {
        List<Employee> employees = daoInstance.getAll();
        if (!employees.isEmpty()) {
            return employees;
        } else {
            throw new NotFoundException("No employees found");
        }
    }

}
