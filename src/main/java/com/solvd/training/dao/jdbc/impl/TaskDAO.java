package com.solvd.training.dao.jdbc.impl;

import com.solvd.training.connections.CustomConnection;
import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.exceptions.DbAccessException;
import com.solvd.training.model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.training.utils.LoggerUtil.log;


public class TaskDAO implements IBaseDAO<Task> {

    private final CustomConnection customConnection = new CustomConnection();

    private static final String CREATE_TASK_SQL = "INSERT INTO tasks (taskName, taskDescription, priority, status, projectId) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_TASK_SQL = "UPDATE tasks SET taskName=?, taskDescription=?, priority=?, status=?, projectId=? WHERE idTask=?";
    private static final String DELETE_TASK_SQL = "DELETE FROM tasks WHERE idTask=?";
    private static final String FIND_TASK_SQL = "SELECT * FROM tasks WHERE idTask=?";
    private static final String GET_ALL_TASKS_SQL = "SELECT idTask, taskName, taskDescription, priority, status, projectId FROM tasks";

    @Override
    public void create(Task task) throws DbAccessException {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TASK_SQL)) {
                setTaskParameters(preparedStatement, task);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            log.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
    }

    @Override
    public void update(int id, Task task) throws DbAccessException {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TASK_SQL)) {
                setTaskParameters(preparedStatement, task);
                preparedStatement.setInt(5, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            log.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
    }

    @Override
    public void delete(int id) throws DbAccessException {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TASK_SQL)) {
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            log.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
    }

    @Override
    public Task find(int id) throws DbAccessException {
        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_TASK_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return mapResultSetToTask(resultSet);
            }
        } catch (SQLException e) {
            log.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
        return null;
    }

    @Override
    public List<Task> getAll() throws DbAccessException {
        List<Task> tasks = new ArrayList<>();

        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_TASKS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                tasks.add(mapResultSetToTask(resultSet));
            }
        } catch (SQLException e) {
            log.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
        return tasks;
    }

    private Task mapResultSetToTask(ResultSet resultSet) throws SQLException {
        return new Task(
                resultSet.getString("task_name"),
                resultSet.getString("task_description"),
                resultSet.getString("priority"),
                resultSet.getString("status")
        );
    }

    private void setTaskParameters(PreparedStatement statement, Task task) throws SQLException {
        statement.setString(1, task.getTaskName());
        statement.setString(2, task.getTaskDescription());
        statement.setString(3, task.getPriority());
        statement.setString(4, task.getStatus());
    }
}
