package com.solvd.training.service;

import com.solvd.training.exceptions.NotFoundException;

public interface IService<T> {

    void create(T entity);

    void update(int id, T entity) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    T find(int id) throws NotFoundException;
}
