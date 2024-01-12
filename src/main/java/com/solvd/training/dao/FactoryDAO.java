package com.solvd.training.dao;

import com.solvd.training.exceptions.DAOException;

public interface FactoryDAO<T extends IBaseDAO<E>, E> {
    T getInstance() throws DAOException;
}


