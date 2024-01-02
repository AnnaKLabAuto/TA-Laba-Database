package com.solvd.training.service.impl;

import com.solvd.training.dao.impl.ProjectDAO;
import com.solvd.training.model.Project;
import com.solvd.training.service.IService;

public class ProjectService implements IService<Project> {

    public final ProjectDAO projectDAO = new ProjectDAO();

    @Override
    public void create(Project project) {
        projectDAO.create(project);
    }

    @Override
    public void update(int id, Project project) {
        projectDAO.update(id, project);
    }

    @Override
    public void delete(int id) {
        projectDAO.delete(id);
    }

    @Override
    public Project find(int id){
        return projectDAO.find(id);
    }
}