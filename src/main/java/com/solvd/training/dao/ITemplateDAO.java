package com.solvd.training.dao;

import com.solvd.training.exceptions.CustomException;
import com.solvd.training.model.Employee;

import java.io.IOException;
import java.sql.SQLException;

public interface ITemplateDAO {

    public void create(Employee employee) throws InterruptedException, SQLException, IOException, ClassNotFoundException, CustomException;

    public void updateById(int id, Employee employee) throws InterruptedException, SQLException, IOException, ClassNotFoundException, CustomException;

    public void deleteById(int id) throws InterruptedException, SQLException, IOException, ClassNotFoundException, CustomException;

    public Employee findById(int id) throws InterruptedException, SQLException, IOException, ClassNotFoundException, CustomException;
}
