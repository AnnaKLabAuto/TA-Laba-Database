package com.solvd.training.dao.impl;

import com.solvd.training.connections.CustomConnection;
import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.model.Department;

import static com.solvd.training.utils.LoggerUtil.log;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DepartmentDAO implements IBaseDAO<Department> {

    private static final Properties SQL_STATEMENTS = loadSqlStatements();
    private CustomConnection customConnection = new CustomConnection();

    private static Properties loadSqlStatements() {
        Properties properties = new Properties();
        try (InputStream input = DepartmentDAO.class.getClassLoader().getResourceAsStream("sql-statements.properties")) {
            properties.load(input);
        } catch (IOException e) {
            log.error(e);
        }
        return properties;
    }

    @Override
    public void create(Department entity) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_STATEMENTS.getProperty("sql.create_department"))) {
                preparedStatement.setString(1, entity.getDepartmentName());
                preparedStatement.setString(2, entity.getDepartmentDescription());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, Department entity) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_STATEMENTS.getProperty("sql.update_by_id_department"))) {
                preparedStatement.setString(1, entity.getDepartmentName());
                preparedStatement.setString(2, entity.getDepartmentDescription());
                preparedStatement.setInt(3, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_STATEMENTS.getProperty("sql.delete_by_id_department"))) {
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Department find(int id) {
        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_STATEMENTS.getProperty("sql.find_department_by_id"));
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return mapDepartment(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Department mapDepartment(ResultSet resultSet) throws SQLException {
        return new Department(
                resultSet.getString("department_name"),
                resultSet.getString("department_description")
        );
    }
}
