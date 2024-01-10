package com.solvd.training.dao.jdbc;

import com.solvd.training.dao.FactoryDAO;
import com.solvd.training.dao.IBaseDAO;

public class JDBCFactoryDAO<T extends IBaseDAO<E>, E> implements FactoryDAO<T, E> {
    private final Class<T> daoClass;

    public JDBCFactoryDAO(Class<T> daoClass) {
        this.daoClass = daoClass;
    }

    @Override
    public T getInstance() {
        try {
            return daoClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

