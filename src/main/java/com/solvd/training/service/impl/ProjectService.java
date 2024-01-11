package com.solvd.training.service.impl;

import com.solvd.training.dao.FactoryDAO;
import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.dao.jdbc.JDBCFactoryDAO;
import com.solvd.training.dao.jdbc.impl.EmployeeDAO;
import com.solvd.training.dao.jdbc.impl.ProjectDAO;
import com.solvd.training.dao.mybatis.MyBatisFactoryDAO;
import com.solvd.training.dao.mybatis.impl.MyBatisEmployeeDAO;
import com.solvd.training.dao.mybatis.impl.MyBatisProjectDAO;
import com.solvd.training.exceptions.DuplicateEntityException;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.model.Employee;
import com.solvd.training.model.Project;
import com.solvd.training.service.IService;

import java.util.List;

public class ProjectService implements IService<Project> {

    private final IBaseDAO<Project> daoInstance;

    public ProjectService(String chosenAccessDataType) {
        FactoryDAO<IBaseDAO<Project>, Project> factoryDAO;
        if ("MY_BATIS".equals(chosenAccessDataType)) {
            factoryDAO = new MyBatisFactoryDAO(MyBatisProjectDAO.class);
        } else if ("JDBC".equals(chosenAccessDataType)) {
            factoryDAO = new JDBCFactoryDAO(ProjectDAO.class);
        } else {
            throw new IllegalArgumentException("Invalid data access type");
        }
        this.daoInstance = factoryDAO.getInstance();
    }

    @Override
    public void create(Project project) throws DuplicateEntityException {
        Project foundProject = daoInstance.find(project.getIdProject());
        if(foundProject == null){
            daoInstance.create(project);
        } else {
            throw new DuplicateEntityException("Project exists in database");
        }
    }

    @Override
    public void update(int id, Project project) throws NotFoundException {
        Project foundProject = daoInstance.find(id);
        if (foundProject != null) {
            daoInstance.update(id, project);
        } else {
            throw new NotFoundException("Can't update Project, because it was not found");
        }
    }

    @Override
    public void delete(int id) throws NotFoundException {
        Project foundProject = daoInstance.find(id);
        if (foundProject != null) {
            daoInstance.delete(id);
        } else {
            throw new NotFoundException("Can't delete Project, because it was not found");
        }
    }

    @Override
    public Project find(int id) throws NotFoundException {
        Project project = daoInstance.find(id);
        if (project != null) {
            return project;
        } else {
            throw new NotFoundException("Project was not found");
        }
    }

    @Override
    public List<Project> getAll() throws NotFoundException {
        List<Project> projects = daoInstance.getAll();
        if (!projects.isEmpty()) {
            return projects;
        } else {
            throw new NotFoundException("No projects found");
        }
    }

}