package com.solvd.training.service.impl;

import com.solvd.training.dao.jdbc.impl.ClientDAO;
import com.solvd.training.exceptions.DuplicateEntityException;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.model.Client;
import com.solvd.training.service.IService;

import java.util.List;

public class ClientService implements IService<Client> {

    public final ClientDAO clientDAO = new ClientDAO();

    @Override
    public void create(Client client) throws DuplicateEntityException {
        Client existingClient = clientDAO.find(client.getIdClient());
        if(existingClient == null){
            clientDAO.create(client);
        } else{
            throw new DuplicateEntityException("Client exists in database");
        }
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

    @Override
    public List<Client> getAll() throws NotFoundException {
        List<Client> clients = clientDAO.getAll();
        if (!clients.isEmpty()) {
            return clients;
        } else {
            throw new NotFoundException("No clients found");
        }
    }
}

