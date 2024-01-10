package com.solvd.training.service.impl;

import com.solvd.training.dao.jdbc.impl.DepartmentDAO;
import com.solvd.training.exceptions.DuplicateEntityException;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.model.Department;
import com.solvd.training.service.IService;

import java.util.List;

public class DepartmentService implements IService<Department> {

    public final DepartmentDAO departmentDAO = new DepartmentDAO();

    @Override
    public void create(Department department) throws DuplicateEntityException {
        Department foundDepartment = departmentDAO.find(department.getIdDepartment());
        if(foundDepartment == null){
            departmentDAO.create(department);
        } else{
            throw new DuplicateEntityException("Department exists in database");
        }
    }

    @Override
    public void update(int id, Department department) throws NotFoundException {
        Department foundDepartment = departmentDAO.find(id);
        if (foundDepartment != null) {
            departmentDAO.update(id, foundDepartment);
        } else {
            throw new NotFoundException("Can't update Department, because it was not found");
        }
    }

    @Override
    public void delete(int id) throws NotFoundException {
        Department foundDepartment = departmentDAO.find(id);
        if (foundDepartment != null) {
            departmentDAO.delete(id);
        } else {
            throw new NotFoundException("Can't delete Department, because it was not found");
        }
    }

    @Override
    public Department find(int id) throws NotFoundException {
        Department department = departmentDAO.find(id);
        if (department != null) {
            return department;
        } else {
            throw new NotFoundException("Department was not found");
        }
    }

    @Override
    public List<Department> getAll() throws NotFoundException {
        List<Department> departments = departmentDAO.getAll();
        if (!departments.isEmpty()) {
            return departments;
        } else {
            throw new NotFoundException("No departments found");
        }
    }

}
