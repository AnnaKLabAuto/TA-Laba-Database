package com.solvd.training.dao.mybatis.interfaces;

import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.model.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ITaskDAO extends IBaseDAO<Task> {

    void create(Task task);

    void update(@Param("idTask") int idTask, @Param("task") Task task);

    void delete(@Param("idTask") int idTask);

    Task find(@Param("idTask") int idTask);

    List<Task> getAll();
}
