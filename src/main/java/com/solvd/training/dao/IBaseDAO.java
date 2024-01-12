package com.solvd.training.dao;

import com.solvd.training.exceptions.DbAccessException;

import java.util.List;

public interface IBaseDAO<T>{

    void create(T entity) throws DbAccessException;

    void update(int id, T entity) throws DbAccessException;

    void delete(int id) throws DbAccessException;

    T find(int id) throws DbAccessException;

    List<T> getAll() throws DbAccessException;
}
