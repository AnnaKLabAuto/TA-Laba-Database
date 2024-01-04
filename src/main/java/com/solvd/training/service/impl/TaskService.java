package com.solvd.training.service.impl;

import com.solvd.training.dao.impl.TaskDAO;
import com.solvd.training.exceptions.DuplicateEntityException;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.model.Task;
import com.solvd.training.service.IService;

public class TaskService implements IService<Task> {

    public final TaskDAO taskDAO = new TaskDAO();

    @Override
    public void create(Task task) throws DuplicateEntityException {
        Task foundTask = taskDAO.find(task.getIdTask());
        if(foundTask == null){
            taskDAO.create(task);
        }
        throw new DuplicateEntityException("Project exists in database");
    }

    @Override
    public void update(int id, Task task) throws NotFoundException {
        Task foundTask = taskDAO.find(id);
        if (foundTask != null) {
            taskDAO.update(id, task);
        } else {
            throw new NotFoundException("Can't update Task, because it was not found");
        }
    }

    @Override
    public void delete(int id) throws NotFoundException {
        Task foundTask = taskDAO.find(id);
        if (foundTask != null) {
            taskDAO.delete(id);
        } else {
            throw new NotFoundException("Can't delete Task, because it was not found");
        }
    }

    @Override
    public Task find(int id) throws NotFoundException {
        Task task = taskDAO.find(id);
        if (task != null) {
            return task;
        } else {
            throw new NotFoundException("Task was not found");
        }
    }
}