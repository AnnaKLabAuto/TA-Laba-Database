package com.solvd.training.service.impl;

import com.solvd.training.dao.impl.TaskDAO;
import com.solvd.training.model.Task;
import com.solvd.training.service.IService;

public class TaskService implements IService<Task> {

    public final TaskDAO taskDAO = new TaskDAO();

    @Override
    public void create(Task task) {
        taskDAO.create(task);
    }

    @Override
    public void update(int id, Task task) {
        taskDAO.update(id, task);
    }

    @Override
    public void delete(int id) {
        taskDAO.delete(id);
    }

    @Override
    public Task find(int id){
        return taskDAO.find(id);
    }
}