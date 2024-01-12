package com.solvd.training.service.impl;

import com.solvd.training.dao.FactoryDAO;
import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.dao.jdbc.JDBCFactoryDAO;
import com.solvd.training.dao.jdbc.impl.DepartmentDAO;
import com.solvd.training.dao.jdbc.impl.EmployeeDAO;
import com.solvd.training.dao.mybatis.MyBatisFactoryDAO;
import com.solvd.training.dao.mybatis.impl.MyBatisDepartmentDAO;
import com.solvd.training.dao.mybatis.impl.MyBatisEmployeeDAO;
import com.solvd.training.exceptions.DbAccessException;
import com.solvd.training.exceptions.DuplicateEntityException;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.model.Department;
import com.solvd.training.model.Employee;
import com.solvd.training.service.IService;

import java.util.List;

public class DepartmentService implements IService<Department> {

    private final IBaseDAO<Department> daoInstance;

    public DepartmentService(String chosenAccessDataType) {
        FactoryDAO<IBaseDAO<Department>, Department> factoryDAO;
        if ("MY_BATIS".equals(chosenAccessDataType)) {
            factoryDAO = new MyBatisFactoryDAO(MyBatisDepartmentDAO.class);
        } else if ("JDBC".equals(chosenAccessDataType)) {
            factoryDAO = new JDBCFactoryDAO(DepartmentDAO.class);
        } else {
            throw new IllegalArgumentException("Invalid data access type");
        }
        this.daoInstance = factoryDAO.getInstance();
    }

    @Override
    public void create(Department department) throws DuplicateEntityException, DbAccessException {
        Department foundDepartment = daoInstance.find(department.getIdDepartment());
        if(foundDepartment == null){
            daoInstance.create(department);
        } else {
            throw new DuplicateEntityException("Department exists in database");
        }
    }

    @Override
    public void update(int id, Department department) throws NotFoundException, DbAccessException {
        Department foundDepartment = daoInstance.find(id);
        if (foundDepartment != null) {
            daoInstance.update(id, foundDepartment);
        } else {
            throw new NotFoundException("Can't update Department, because it was not found");
        }
    }

    @Override
    public void delete(int id) throws NotFoundException, DbAccessException {
        Department foundDepartment = daoInstance.find(id);
        if (foundDepartment != null) {
            daoInstance.delete(id);
        } else {
            throw new NotFoundException("Can't delete Department, because it was not found");
        }
    }

    @Override
    public Department find(int id) throws NotFoundException, DbAccessException {
        Department department = daoInstance.find(id);
        if (department != null) {
            return department;
        } else {
            throw new NotFoundException("Department was not found");
        }
    }

    @Override
    public List<Department> getAll() throws NotFoundException, DbAccessException {
        List<Department> departments = daoInstance.getAll();
        if (!departments.isEmpty()) {
            return departments;
        } else {
            throw new NotFoundException("No departments found");
        }
    }

}
