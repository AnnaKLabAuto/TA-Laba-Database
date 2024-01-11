package com.solvd.training.dao.mybatis.impl;

import com.solvd.training.dao.SqlSessionFactoryHolder;
import com.solvd.training.dao.mybatis.interfaces.ITaskDAO;
import com.solvd.training.model.Task;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyBatisTaskDAO implements ITaskDAO {

    @Override
    public void create(Task task) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            ITaskDAO taskDAO = sqlSession.getMapper(ITaskDAO.class);
            taskDAO.create(task);
        }
    }

    @Override
    public void update(int id, Task task) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            ITaskDAO taskDAO = sqlSession.getMapper(ITaskDAO.class);
            taskDAO.update(id, task);
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            ITaskDAO taskDAO = sqlSession.getMapper(ITaskDAO.class);
            taskDAO.delete(id);
        }
    }

    @Override
    public Task find(int id) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            ITaskDAO taskDAO = sqlSession.getMapper(ITaskDAO.class);
            return taskDAO.find(id);
        }
    }

    @Override
    public List<Task> getAll() {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            ITaskDAO taskDAO = sqlSession.getMapper(ITaskDAO.class);
            return taskDAO.getAll();
        }
    }
}

