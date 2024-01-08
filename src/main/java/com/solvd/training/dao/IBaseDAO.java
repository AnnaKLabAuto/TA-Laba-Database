package com.solvd.training.dao;

import java.util.List;

public interface IBaseDAO<T>{

    void create(T entity);

    void update(int id, T entity);

    void delete(int id);

    T find(int id);

    List<T> getAll();
}
