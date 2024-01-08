package com.solvd.training.service;

import com.solvd.training.exceptions.DuplicateEntityException;
import com.solvd.training.exceptions.NotFoundException;

import java.util.List;

public interface IService<T> {

    void create(T entity) throws DuplicateEntityException;

    void update(int id, T entity) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    T find(int id) throws NotFoundException;

    List<T> getAll() throws NotFoundException;
}
