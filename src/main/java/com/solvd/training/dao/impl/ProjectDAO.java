package com.solvd.training.dao.impl;

import com.solvd.training.connections.CustomConnection;
import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.model.Project;

import static com.solvd.training.utils.LoggerUtil.log;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ProjectDAO implements IBaseDAO<Project> {

    private static final Properties SQL_STATEMENTS = loadSqlStatements();
    private CustomConnection customConnection = new CustomConnection();

    private static Properties loadSqlStatements() {
        Properties properties = new Properties();
        try (InputStream input = ProjectDAO.class.getClassLoader().getResourceAsStream("sql-statements.properties")) {
            properties.load(input);
        } catch (IOException e) {
            log.error(e);
        }
        return properties;
    }

    @Override
    public void create(Project entity) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_STATEMENTS.getProperty("sql.create_project"))) {
                preparedStatement.setString(1, entity.getProjectName());
                preparedStatement.setString(2, entity.getProjectDescription());
                preparedStatement.setDate(3, new java.sql.Date(entity.getStartDate().getTime()));
                preparedStatement.setDate(4, new java.sql.Date(entity.getDueDate().getTime()));
                preparedStatement.setString(5, entity.getPriority());
                preparedStatement.setInt(6, entity.getProjectStatusesId());
                preparedStatement.setInt(7, entity.getClientsId());
                preparedStatement.setInt(8, entity.getProjectBudgetsId());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, Project entity) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_STATEMENTS.getProperty("sql.update_by_id_project"))) {
                preparedStatement.setString(1, entity.getProjectName());
                preparedStatement.setString(2, entity.getProjectDescription());
                preparedStatement.setDate(3, new java.sql.Date(entity.getStartDate().getTime()));
                preparedStatement.setDate(4, new java.sql.Date(entity.getDueDate().getTime()));
                preparedStatement.setString(5, entity.getPriority());
                preparedStatement.setInt(6, entity.getProjectStatusesId());
                preparedStatement.setInt(7, entity.getClientsId());
                preparedStatement.setInt(8, entity.getProjectBudgetsId());
                preparedStatement.setInt(9, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_STATEMENTS.getProperty("sql.delete_by_id_project"))) {
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Project find(int id) {
        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_STATEMENTS.getProperty("sql.find_project_by_id"));
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return mapProject(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Project mapProject(ResultSet resultSet) throws SQLException {
        return new Project(
                resultSet.getString("project_name"),
                resultSet.getString("project_description"),
                new Date(resultSet.getDate("start_date").getTime()),
                new Date(resultSet.getDate("due_date").getTime()),
                resultSet.getString("priority"),
                resultSet.getInt("project_statuses_id"),
                resultSet.getInt("clientsId"),
                resultSet.getInt("project_budgets_id")
        );
    }
}
