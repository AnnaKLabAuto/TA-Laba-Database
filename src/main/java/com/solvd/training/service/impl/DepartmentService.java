package com.solvd.training.service.impl;

import com.solvd.training.dao.impl.DepartmentDAO;
import com.solvd.training.model.Department;
import com.solvd.training.service.IService;

public class DepartmentService implements IService<Department> {

    public final DepartmentDAO departmentDAO = new DepartmentDAO();

    @Override
    public void create(Department department) {
        departmentDAO.create(department);
    }

    @Override
    public void update(int id, Department department) {
        departmentDAO.update(id, department);
    }

    @Override
    public void delete(int id) {
        departmentDAO.delete(id);
    }

    @Override
    public Department find(int id){
        return departmentDAO.find(id);
    }
}
