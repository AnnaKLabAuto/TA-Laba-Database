package com.solvd.training.dao.mybatis;

import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.model.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDepartmentDAO extends IBaseDAO<Department> {

    void create(Department department);

    void update(@Param("idDepartment") int idDepartment, @Param("department") Department department);

    void delete(@Param("idDepartment") int idDepartment);

    Department find(@Param("idDepartment") int idDepartment);

    List<Department> getAll();
}
