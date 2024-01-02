package com.solvd.training.service.impl;

import com.solvd.training.dao.impl.ClientDAO;
import com.solvd.training.model.Client;
import com.solvd.training.service.IService;

public class ClientService implements IService<Client> {

    public final ClientDAO clientDAO = new ClientDAO();

    @Override
    public void create(Client client) {
        clientDAO.create(client);
    }

    @Override
    public void update(int id, Client client) {
        clientDAO.update(id, client);
    }

    @Override
    public void delete(int id) {
        clientDAO.delete(id);
    }

    @Override
    public Client find(int id){
        return clientDAO.find(id);
    }
}

