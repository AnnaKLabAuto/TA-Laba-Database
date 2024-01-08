package com.solvd.training.dao.mybatis.impl;

import com.solvd.training.dao.DAOConfig;
import com.solvd.training.dao.mybatis.IEmployeeDAO;
import com.solvd.training.model.Employee;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {

    @Override
    public void create(Employee employee) {
        try (SqlSession sqlSession = DAOConfig.getSessionFactory().openSession(true)) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.create(employee);
        }
    }

    @Override
    public void update(int id, Employee employee) {
        try (SqlSession sqlSession = DAOConfig.getSessionFactory().openSession(true)) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.update(id, employee);
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = DAOConfig.getSessionFactory().openSession(true)) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.delete(id);
        }
    }

    @Override
    public Employee find(int id) {
        try (SqlSession sqlSession = DAOConfig.getSessionFactory().openSession(true)) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            return employeeDAO.find(id);
        }
    }

    @Override
    public List<Employee> getAll() {
        try (SqlSession sqlSession = DAOConfig.getSessionFactory().openSession(true)) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            return employeeDAO.getAll();
        }
    }
}
