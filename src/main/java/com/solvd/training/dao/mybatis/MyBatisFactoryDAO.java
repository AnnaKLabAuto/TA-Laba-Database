package com.solvd.training.dao.mybatis;

import com.solvd.training.dao.FactoryDAO;
import com.solvd.training.dao.mybatis.impl.MyBatisEmployeeDAO;
import com.solvd.training.model.Employee;

public class MyBatisFactoryDAO implements FactoryDAO<MyBatisEmployeeDAO, Employee> {

    @Override
    public MyBatisEmployeeDAO getInstance(Class<MyBatisEmployeeDAO> type) {
        return new MyBatisEmployeeDAO();
    }

}


