package com.solvd.training.dao.mybatis;

import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IEmployeeDAO extends IBaseDAO<Employee> {

    void create(Employee employee);

    void update(@Param("idEmployee") int idEmployee, Employee employee);

    void delete(@Param("idEmployee") int idEmployee);

    Employee find(@Param("idEmployee") int idEmployee);

    List<Employee> getAll();
}
