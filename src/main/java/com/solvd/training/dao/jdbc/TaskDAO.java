package com.solvd.training.dao.jdbc;

import com.solvd.training.connections.CustomConnection;
import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.model.Task;
import com.solvd.training.utils.LoadSQLStatementsUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TaskDAO implements IBaseDAO<Task> {

    private final LoadSQLStatementsUtil loadSQLStatementsUtil = new LoadSQLStatementsUtil();
    private final CustomConnection customConnection = new CustomConnection();

    @Override
    public void create(Task entity) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.create_task"))) {
                preparedStatement.setString(1, entity.getTaskName());
                preparedStatement.setString(2, entity.getTaskDescription());
                preparedStatement.setString(3, entity.getPriority());
                preparedStatement.setString(4, entity.getStatus());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
        }
    }

    @Override
    public void update(int id, Task entity) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.update_by_id_task"))) {
                preparedStatement.setString(1, entity.getTaskName());
                preparedStatement.setString(2, entity.getTaskDescription());
                preparedStatement.setString(3, entity.getPriority());
                preparedStatement.setString(4, entity.getStatus());
                preparedStatement.setInt(5, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.delete_by_id_task"))) {
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
        }
    }

    @Override
    public Task find(int id) {
        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.find_task_by_id"));
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return mapTask(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
        }
        return null;
    }

    @Override
    public List<Task> getAll() {
        List<Task> tasks = new ArrayList<>();

        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.get_all_tasks"))) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                tasks.add(mapTask(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
        }

        return tasks;
    }


    private Task mapTask(ResultSet resultSet) throws SQLException {
        return new Task(
                resultSet.getString("task_name"),
                resultSet.getString("task_description"),
                resultSet.getString("priority"),
                resultSet.getString("status")
        );
    }
}
