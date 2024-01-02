package com.solvd.training.dao;

public interface IBaseDAO<T>{

    void create(T entity);

    void update(int id, T entity);

    void delete(int id);

    T find(int id);
}
