package com.solvd.training.dao.mybatis;

import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.model.Client;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IClientDAO extends IBaseDAO<Client> {

    void create(Client client);

    void update(@Param("idClient") int idClient, @Param("client") Client client);

    void delete(@Param("idClient") int idClient);

    Client find(@Param("idClient") int idClient);

    List<Client> getAll();
}
