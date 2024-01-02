package com.solvd.training.service;

import java.sql.SQLException;

public interface IService<T> {

    void create(T entity);

    void update(int id, T entity);

    void delete(int id);

    T find(int id) throws SQLException;
}
