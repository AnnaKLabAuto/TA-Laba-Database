package com.solvd.training.dao.mybatis.impl;

import com.solvd.training.dao.SqlSessionFactoryHolder;
import com.solvd.training.dao.mybatis.interfaces.IEmployeeDAO;
import com.solvd.training.model.Employee;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyBatisEmployeeDAO implements IEmployeeDAO {

    @Override
    public void create(Employee employee) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.create(employee);
        }
    }

    @Override
    public void update(int id, Employee employee) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.update(id, employee);
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.delete(id);
        }
    }

    @Override
    public Employee find(int id) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            return employeeDAO.find(id);
        }
    }

    @Override
    public List<Employee> getAll() {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            return employeeDAO.getAll();
        }
    }
}
