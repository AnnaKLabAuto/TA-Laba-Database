package com.solvd.training.service;

import com.solvd.training.exceptions.DbAccessException;
import com.solvd.training.exceptions.DuplicateEntityException;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.exceptions.UnauthorizedAccessException;

import java.util.List;

public interface IService<T> {

    void create(T entity) throws DuplicateEntityException, DbAccessException, UnauthorizedAccessException;

    void update(int id, T entity) throws NotFoundException, DbAccessException, UnauthorizedAccessException;

    void delete(int id) throws NotFoundException, DbAccessException, UnauthorizedAccessException;

    T find(int id) throws NotFoundException, DbAccessException, UnauthorizedAccessException;

    List<T> getAll() throws NotFoundException, DbAccessException, UnauthorizedAccessException;
}
