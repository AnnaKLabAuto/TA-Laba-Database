package com.solvd.training.dao.impl;

import com.solvd.training.connections.CustomConnection;
import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.model.Project;
import com.solvd.training.utils.LoadSQLStatementsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.training.utils.LoggerUtil.log;


public class ProjectDAO implements IBaseDAO<Project> {

    private final LoadSQLStatementsUtil loadSQLStatementsUtil = new LoadSQLStatementsUtil();
    private final CustomConnection customConnection = new CustomConnection();

    @Override
    public void create(Project entity) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.create_project"))) {
                preparedStatement.setString(1, entity.getProjectName());
                preparedStatement.setString(2, entity.getProjectDescription());
                preparedStatement.setDate(3, new java.sql.Date(entity.getStartDate().getTime()));
                preparedStatement.setDate(4, new java.sql.Date(entity.getDueDate().getTime()));
                preparedStatement.setString(5, entity.getPriority());
                preparedStatement.setInt(6, entity.getProjectStatusId());
                preparedStatement.setInt(7, entity.getClientId());
                preparedStatement.setInt(8, entity.getProjectBudgetId());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
        }
    }

    @Override
    public void update(int id, Project entity) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.update_by_id_project"))) {
                preparedStatement.setString(1, entity.getProjectName());
                preparedStatement.setString(2, entity.getProjectDescription());
                preparedStatement.setDate(3, new java.sql.Date(entity.getStartDate().getTime()));
                preparedStatement.setDate(4, new java.sql.Date(entity.getDueDate().getTime()));
                preparedStatement.setString(5, entity.getPriority());
                preparedStatement.setInt(6, entity.getProjectStatusId());
                preparedStatement.setInt(7, entity.getClientId());
                preparedStatement.setInt(8, entity.getProjectBudgetId());
                preparedStatement.setInt(9, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.delete_by_id_project"))) {
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
        }
    }

    @Override
    public Project find(int id) {
        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.find_project_by_id"));
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return mapProject(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
        }
        return null;
    }

    @Override
    public List<Project> getAll() {
        List<Project> projects = new ArrayList<>();

        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.get_all_projects"))) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                projects.add(mapProject(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
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
                resultSet.getInt("project_statuses_id"),
                resultSet.getInt("clientsId"),
                resultSet.getInt("project_budgets_id")
        );
    }
}
