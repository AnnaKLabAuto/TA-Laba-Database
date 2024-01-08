package com.solvd.training.service.impl;

import com.solvd.training.dao.jdbc.ProjectDAO;
import com.solvd.training.exceptions.DuplicateEntityException;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.model.Project;
import com.solvd.training.service.IService;

import java.util.List;

public class ProjectService implements IService<Project> {

    public final ProjectDAO projectDAO = new ProjectDAO();

    @Override
    public void create(Project project) throws DuplicateEntityException {
        Project foundProject = projectDAO.find(project.getIdProject());
        if(foundProject == null){
            projectDAO.create(project);
        }
        throw new DuplicateEntityException("Project exists in database");
    }

    @Override
    public void update(int id, Project project) throws NotFoundException {
        Project foundProject = projectDAO.find(id);
        if (foundProject != null) {
            projectDAO.update(id, project);
        } else {
            throw new NotFoundException("Can't update Project, because it was not found");
        }
    }

    @Override
    public void delete(int id) throws NotFoundException {
        Project foundProject = projectDAO.find(id);
        if (foundProject != null) {
            projectDAO.delete(id);
        } else {
            throw new NotFoundException("Can't delete Project, because it was not found");
        }
    }

    @Override
    public Project find(int id) throws NotFoundException {
        Project project = projectDAO.find(id);
        if (project != null) {
            return project;
        } else {
            throw new NotFoundException("Project was not found");
        }
    }

    @Override
    public List<Project> getAll() throws NotFoundException {
        List<Project> projects = projectDAO.getAll();
        if (!projects.isEmpty()) {
            return projects;
        } else {
            throw new NotFoundException("No projects found");
        }
    }

}