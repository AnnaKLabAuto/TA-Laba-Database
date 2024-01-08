package com.solvd.training.dao.mybatis;

import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IEmployeeDAO extends IBaseDAO<Employee> {

    void create(@Param("employee") Employee employee);

    void update(@Param("id") int id, @Param("employee") Employee employee);

    void delete(@Param("id") int id);

    Employee find(@Param("id") int id);

    List<Employee> getAll();
}
