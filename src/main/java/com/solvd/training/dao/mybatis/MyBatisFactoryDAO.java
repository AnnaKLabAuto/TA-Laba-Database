package com.solvd.training.dao.mybatis;

import com.solvd.training.dao.FactoryDAO;
import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.exceptions.DAOException;

import static com.solvd.training.utils.LoggerUtil.log;

public class MyBatisFactoryDAO<T extends IBaseDAO<E>, E> implements FactoryDAO<T, E> {
    private final Class<T> daoClass;

    public MyBatisFactoryDAO(Class<T> daoClass) {
        this.daoClass = daoClass;
    }

    @Override
    public T getInstance() throws DAOException {
        try {
            return daoClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("Could not create instance of MyBatis DAO class", e);
            throw new DAOException("Could not create instance of MyBatis DAO class", e);
        }
    }
}
