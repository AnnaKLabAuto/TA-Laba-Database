package com.solvd.training.dao.jdbc.impl;

import com.solvd.training.connections.CustomConnection;
import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.exceptions.DbAccessException;
import com.solvd.training.model.Project;
import com.solvd.training.utils.LoadSQLStatementsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.training.utils.LoggerUtil.log;


public class ProjectDAO implements IBaseDAO<Project> {

    private final CustomConnection customConnection = new CustomConnection();

    private static final String CREATE_PROJECT_SQL = "INSERT INTO projects (projectName, projectDescription, startDate, dueDate, priority, projectStatusId, clientId, projectBudgetId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_PROJECT_SQL = "UPDATE projects SET projectName=?, projectDescription=?, startDate=?, dueDate=?, priority=?, projectStatusId=?, clientId=?, projectBudgetId=? WHERE idProject=?";
    private static final String DELETE_PROJECT_SQL = "DELETE FROM projects WHERE idProject=?";
    private static final String FIND_PROJECT_SQL = "SELECT * FROM projects WHERE idProject=?";
    private static final String GET_ALL_PROJECTS_SQL = "SELECT idProject, projectName, projectDescription, startDate, dueDate, priority, projectStatusId, clientId, projectBudgetId FROM projects";

    private void setProjectDetails(PreparedStatement statement, Project project) throws SQLException {
        statement.setString(1, project.getProjectName());
        statement.setString(2, project.getProjectDescription());
        statement.setDate(3, new java.sql.Date(project.getStartDate().getTime()));
        statement.setDate(4, new java.sql.Date(project.getDueDate().getTime()));
        statement.setString(5, project.getPriority());
        statement.setInt(6, project.getProjectStatusId());
        statement.setInt(7, project.getClientId());
        statement.setInt(8, project.getProjectBudgetId());
    }

    @Override
    public void create(Project project) throws DbAccessException {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PROJECT_SQL)) {
                setProjectDetails(preparedStatement, project);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            log.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
    }

    @Override
    public void update(int id, Project project) throws DbAccessException {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROJECT_SQL)) {
                setProjectDetails(preparedStatement, project);
                preparedStatement.setInt(9, id);

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
            try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PROJECT_SQL)) {
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            log.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
    }

    @Override
    public Project find(int id) throws DbAccessException {
        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_PROJECT_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return mapProject(resultSet);
            }
        } catch (SQLException e) {
            log.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
        return null;
    }

    @Override
    public List<Project> getAll() throws DbAccessException {
        List<Project> projects = new ArrayList<>();

        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PROJECTS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                projects.add(mapProject(resultSet));
            }
        } catch (SQLException e) {
            log.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
        return projects;
    }

    private Project mapProject(ResultSet resultSet) throws SQLException {
        return new Project(
                resultSet.getString("project_name"),
                resultSet.getString("project_description"),
                new Date(resultSet.getDate("start_date").getTime()),
                new Date(resultSet.getDate("due_date").getTime()),
                resultSet.getString("priority"),
                resultSet.getInt("project_status_id"),
                resultSet.getInt("clientId"),
                resultSet.getInt("project_budget_id")
        );
    }
}
