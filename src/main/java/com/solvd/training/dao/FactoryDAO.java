package com.solvd.training.dao;

public interface FactoryDAO<T extends IBaseDAO<E>, E> {
    T getInstance();
}


