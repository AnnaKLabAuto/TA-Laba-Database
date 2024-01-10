package com.solvd.training.dao.mybatis;

import com.solvd.training.dao.FactoryDAO;
import com.solvd.training.dao.IBaseDAO;

public class MyBatisFactoryDAO<T extends IBaseDAO<E>, E> implements FactoryDAO<T, E> {
    private final Class<T> daoClass;

    public MyBatisFactoryDAO(Class<T> daoClass) {
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
