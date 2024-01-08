package com.solvd.training.dao.jdbc;

import com.solvd.training.dao.FactoryDAO;
import com.solvd.training.dao.jdbc.impl.EmployeeDAO;
import com.solvd.training.model.Employee;

public class JDBCFactoryDAO implements FactoryDAO<EmployeeDAO, Employee> {

    @Override
    public EmployeeDAO getInstance(Class<EmployeeDAO> type) {
        return new EmployeeDAO();
    }
}
