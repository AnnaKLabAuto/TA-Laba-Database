package com.solvd.training.dao.impl;

import com.solvd.training.connections.CustomConnection;
import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.model.Task;

import static com.solvd.training.utils.LoggerUtil.log;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class TaskDAO implements IBaseDAO<Task> {

    private static final Properties SQL_STATEMENTS = loadSqlStatements();
    private CustomConnection customConnection = new CustomConnection();

    private static Properties loadSqlStatements() {
        Properties properties = new Properties();
        try (InputStream input = TaskDAO.class.getClassLoader().getResourceAsStream("sql-statements.properties")) {
            properties.load(input);
        } catch (IOException e) {
            log.error(e);
        }
        return properties;
    }

    @Override
    public void create(Task entity) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_STATEMENTS.getProperty("sql.create_task"))) {
                preparedStatement.setString(1, entity.getTaskName());
                preparedStatement.setString(2, entity.getTaskDescription());
                preparedStatement.setString(3, entity.getPriority());
                preparedStatement.setString(4, entity.getStatus());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, Task entity) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_STATEMENTS.getProperty("sql.update_by_id_task"))) {
                preparedStatement.setString(1, entity.getTaskName());
                preparedStatement.setString(2, entity.getTaskDescription());
                preparedStatement.setString(3, entity.getPriority());
                preparedStatement.setString(4, entity.getStatus());
                preparedStatement.setInt(5, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_STATEMENTS.getProperty("sql.delete_by_id_task"))) {
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Task find(int id) {
        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_STATEMENTS.getProperty("sql.find_task_by_id"));
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return mapTask(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
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
