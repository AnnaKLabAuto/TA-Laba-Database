package com.solvd.training.dao.mybatis.impl;

import com.solvd.training.dao.SqlSessionFactoryHolder;
import com.solvd.training.dao.mybatis.interfaces.IClientDAO;
import com.solvd.training.model.Client;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyBatisClientDAO implements IClientDAO {

    @Override
    public void create(Client client) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IClientDAO clientDAO = sqlSession.getMapper(IClientDAO.class);
            clientDAO.create(client);
        }
    }

    @Override
    public void update(int id, Client client) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IClientDAO clientDAO = sqlSession.getMapper(IClientDAO.class);
            clientDAO.update(id, client);
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IClientDAO clientDAO = sqlSession.getMapper(IClientDAO.class);
            clientDAO.delete(id);
        }
    }

    @Override
    public Client find(int id) {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IClientDAO clientDAO = sqlSession.getMapper(IClientDAO.class);
            return clientDAO.find(id);
        }
    }

    @Override
    public List<Client> getAll() {
        try (SqlSession sqlSession = SqlSessionFactoryHolder.getSessionFactory().openSession(true)) {
            IClientDAO clientDAO = sqlSession.getMapper(IClientDAO.class);
            return clientDAO.getAll();
        }
    }
}

