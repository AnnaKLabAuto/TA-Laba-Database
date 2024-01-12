package com.solvd.training.service.impl;

import com.solvd.training.dao.FactoryDAO;
import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.dao.jdbc.JDBCFactoryDAO;
import com.solvd.training.dao.jdbc.impl.EmployeeDAO;
import com.solvd.training.dao.jdbc.impl.TaskDAO;
import com.solvd.training.dao.mybatis.MyBatisFactoryDAO;
import com.solvd.training.dao.mybatis.impl.MyBatisEmployeeDAO;
import com.solvd.training.dao.mybatis.impl.MyBatisTaskDAO;
import com.solvd.training.exceptions.DAOException;
import com.solvd.training.exceptions.DbAccessException;
import com.solvd.training.exceptions.DuplicateEntityException;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.model.Employee;
import com.solvd.training.model.Task;
import com.solvd.training.service.IService;

import java.util.List;

public class TaskService implements IService<Task> {

    private final IBaseDAO<Task> daoInstance;

    public TaskService(String chosenAccessDataType) throws DAOException {
        FactoryDAO<IBaseDAO<Task>, Task> factoryDAO;
        if ("MY_BATIS".equals(chosenAccessDataType)) {
            factoryDAO = new MyBatisFactoryDAO(MyBatisTaskDAO.class);
        } else if ("JDBC".equals(chosenAccessDataType)) {
            factoryDAO = new JDBCFactoryDAO(TaskDAO.class);
        } else {
            throw new IllegalArgumentException("Invalid data access type");
        }
        this.daoInstance = factoryDAO.getInstance();
    }

    @Override
    public void create(Task task) throws DuplicateEntityException, DbAccessException {
        Task foundTask = daoInstance.find(task.getIdTask());
        if(foundTask == null){
            daoInstance.create(task);
        } else {
            throw new DuplicateEntityException("Project exists in database");
        }
    }

    @Override
    public void update(int id, Task task) throws NotFoundException, DbAccessException {
        Task foundTask = daoInstance.find(id);
        if (foundTask != null) {
            daoInstance.update(id, task);
        } else {
            throw new NotFoundException("Can't update Task, because it was not found");
        }
    }

    @Override
    public void delete(int id) throws NotFoundException, DbAccessException {
        Task foundTask = daoInstance.find(id);
        if (foundTask != null) {
            daoInstance.delete(id);
        } else {
            throw new NotFoundException("Can't delete Task, because it was not found");
        }
    }

    @Override
    public Task find(int id) throws NotFoundException, DbAccessException {
        Task task = daoInstance.find(id);
        if (task != null) {
            return task;
        } else {
            throw new NotFoundException("Task was not found");
        }
    }

    @Override
    public List<Task> getAll() throws NotFoundException, DbAccessException {
       List<Task> tasks = daoInstance.getAll();
       if (!tasks.isEmpty()) {
           return tasks;
       } else {
           throw new NotFoundException("No tasks found");
       }
    }

}