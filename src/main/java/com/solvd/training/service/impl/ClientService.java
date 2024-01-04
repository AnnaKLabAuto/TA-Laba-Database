package com.solvd.training.service.impl;

import com.solvd.training.dao.impl.ClientDAO;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.model.Client;
import com.solvd.training.service.IService;

public class ClientService implements IService<Client> {

    public final ClientDAO clientDAO = new ClientDAO();

    @Override
    public void create(Client client) {
        clientDAO.create(client);
    }

    @Override
    public void update(int id, Client client) throws NotFoundException {
        Client foundClient = clientDAO.find(id);
        if (foundClient != null) {
            clientDAO.update(id, foundClient);
        } else {
            throw new NotFoundException("Can't update Client, because it was not found");
        }
    }

    @Override
    public void delete(int id) throws NotFoundException {
        Client foundClient = clientDAO.find(id);
        if (foundClient != null) {
            clientDAO.delete(id);
        } else {
            throw new NotFoundException("Can't delete Client, because it was not found");
        }
    }

    @Override
    public Client find(int id) throws NotFoundException {
        Client client = clientDAO.find(id);
        if (client != null) {
            return client;
        } else {
            throw new NotFoundException("Client was not found");
        }
    }
}

