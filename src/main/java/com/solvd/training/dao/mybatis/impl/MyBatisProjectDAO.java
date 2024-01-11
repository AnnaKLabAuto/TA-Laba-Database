package com.solvd.training.dao.mybatis.impl;

import com.solvd.training.dao.SqlSessionFactoryHolder;
import com.solvd.training.dao.mybatis.IProjectDAO;
import com.solvd.training.model.Project;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyBatisProjectDAO implements IProjectDAO {

    @Override
    public void create(Project project) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IProjectDAO projectDAO = sqlSession.getMapper(IProjectDAO.class);
            projectDAO.create(project);
        }
    }

    @Override
    public void update(int id, Project project) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IProjectDAO projectDAO = sqlSession.getMapper(IProjectDAO.class);
            projectDAO.update(id, project);
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IProjectDAO projectDAO = sqlSession.getMapper(IProjectDAO.class);
            projectDAO.delete(id);
        }
    }

    @Override
    public Project find(int id) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IProjectDAO projectDAO = sqlSession.getMapper(IProjectDAO.class);
            return projectDAO.find(id);
        }
    }

    @Override
    public List<Project> getAll() {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IProjectDAO projectDAO = sqlSession.getMapper(IProjectDAO.class);
            return projectDAO.getAll();
        }
    }
}

