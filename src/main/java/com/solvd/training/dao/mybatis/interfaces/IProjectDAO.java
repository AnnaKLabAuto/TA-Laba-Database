package com.solvd.training.dao.mybatis.interfaces;

import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.model.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IProjectDAO extends IBaseDAO<Project> {

    void create(Project project);

    void update(@Param("idProject") int idProject, @Param("project") Project project);

    void delete(@Param("idProject") int idProject);

    Project find(@Param("idProject") int idProject);

    List<Project> getAll();
}
