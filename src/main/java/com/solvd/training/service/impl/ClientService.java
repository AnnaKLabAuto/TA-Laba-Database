package com.solvd.training.service.impl;

import com.solvd.training.dao.FactoryDAO;
import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.dao.jdbc.JDBCFactoryDAO;
import com.solvd.training.dao.jdbc.impl.ClientDAO;
import com.solvd.training.dao.mybatis.MyBatisFactoryDAO;
import com.solvd.training.dao.mybatis.impl.MyBatisClientDAO;
import com.solvd.training.exceptions.DbAccessException;
import com.solvd.training.exceptions.DuplicateEntityException;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.model.Client;
import com.solvd.training.service.IService;

import java.util.List;

public class ClientService implements IService<Client> {

    private final IBaseDAO<Client> daoInstance;

    public ClientService(String chosenAccessDataType) {
        FactoryDAO<IBaseDAO<Client>, Client> factoryDAO;
        if ("MY_BATIS".equals(chosenAccessDataType)) {
            factoryDAO = new MyBatisFactoryDAO(MyBatisClientDAO.class);
        } else if ("JDBC".equals(chosenAccessDataType)) {
            factoryDAO = new JDBCFactoryDAO(ClientDAO.class);
        } else {
            throw new IllegalArgumentException("Invalid data access type");
        }
        this.daoInstance = factoryDAO.getInstance();
    }

    @Override
    public void create(Client client) throws DuplicateEntityException, DbAccessException {
        Client existingClient = daoInstance.find(client.getIdClient());
        if(existingClient == null){
            daoInstance.create(client);
        } else{
            throw new DuplicateEntityException("Client exists in database");
        }
    }

    @Override
    public void update(int id, Client client) throws NotFoundException, DbAccessException {
        Client foundClient = daoInstance.find(id);
        if (foundClient != null) {
            daoInstance.update(id, foundClient);
        } else {
            throw new NotFoundException("Can't update Client, because it was not found");
        }
    }

    @Override
    public void delete(int id) throws NotFoundException, DbAccessException {
        Client foundClient = daoInstance.find(id);
        if (foundClient != null) {
            daoInstance.delete(id);
        } else {
            throw new NotFoundException("Can't delete Client, because it was not found");
        }
    }

    @Override
    public Client find(int id) throws NotFoundException, DbAccessException {
        Client client = daoInstance.find(id);
        if (client != null) {
            return client;
        } else {
            throw new NotFoundException("Client was not found");
        }
    }

    @Override
    public List<Client> getAll() throws NotFoundException, DbAccessException {
        List<Client> clients = daoInstance.getAll();
        if (!clients.isEmpty()) {
            return clients;
        } else {
            throw new NotFoundException("No clients found");
        }
    }
}

