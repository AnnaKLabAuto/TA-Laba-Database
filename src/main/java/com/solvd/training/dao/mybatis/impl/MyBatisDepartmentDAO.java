package com.solvd.training.dao.mybatis.impl;

import com.solvd.training.dao.SqlSessionFactoryHolder;
import com.solvd.training.dao.mybatis.interfaces.IDepartmentDAO;
import com.solvd.training.model.Department;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyBatisDepartmentDAO implements IDepartmentDAO {

    @Override
    public void create(Department department) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IDepartmentDAO departmentDAO = sqlSession.getMapper(IDepartmentDAO.class);
            departmentDAO.create(department);
        }
    }

    @Override
    public void update(int id, Department department) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IDepartmentDAO departmentDAO = sqlSession.getMapper(IDepartmentDAO.class);
            departmentDAO.update(id, department);
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IDepartmentDAO departmentDAO = sqlSession.getMapper(IDepartmentDAO.class);
            departmentDAO.delete(id);
        }
    }

    @Override
    public Department find(int id) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IDepartmentDAO departmentDAO = sqlSession.getMapper(IDepartmentDAO.class);
            return departmentDAO.find(id);
        }
    }

    @Override
    public List<Department> getAll() {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IDepartmentDAO departmentDAO = sqlSession.getMapper(IDepartmentDAO.class);
            return departmentDAO.getAll();
        }
    }
}

