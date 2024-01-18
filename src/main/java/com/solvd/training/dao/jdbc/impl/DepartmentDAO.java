package com.solvd.training.dao.jdbc.impl;

import com.solvd.training.connections.CustomConnection;
import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.exceptions.DbAccessException;
import com.solvd.training.model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.training.utils.LoggerUtil.LOGGER;

public class DepartmentDAO implements IBaseDAO<Department> {

    private final CustomConnection customConnection = new CustomConnection();
    private static final String CREATE_DEPARTMENT_SQL = "INSERT INTO departments (department_name, department_description) VALUES (?, ?)";
    private static final String UPDATE_DEPARTMENT_SQL = "UPDATE departments SET department_name=?, department_description=? WHERE id_department=?";
    private static final String DELETE_DEPARTMENT_SQL = "DELETE FROM departments WHERE id_department=?";
    private static final String FIND_DEPARTMENT_SQL = "SELECT * FROM departments WHERE id_department=?";
    private static final String GET_ALL_DEPARTMENTS_SQL = "SELECT id_department, department_name, department_description FROM departments";

    @Override
    public void create(Department department) throws DbAccessException {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_DEPARTMENT_SQL)) {
                setDepartmentParameters(preparedStatement, department);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
    }

    @Override
    public void update(int id, Department department) throws DbAccessException {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DEPARTMENT_SQL)) {
                setDepartmentParameters(preparedStatement, department);
                preparedStatement.setInt(3, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
    }

    @Override
    public void delete(int id) throws DbAccessException {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DEPARTMENT_SQL)) {
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
    }

    @Override
    public Department find(int id) throws DbAccessException {
        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_DEPARTMENT_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return mapResultSetToDepartment(resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
        return null;
    }

    @Override
    public List<Department> getAll() throws DbAccessException {
        List<Department> departments = new ArrayList<>();

        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_DEPARTMENTS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                departments.add(mapResultSetToDepartment(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
        return departments;
    }

    private Department mapResultSetToDepartment(ResultSet resultSet) throws SQLException {
        return new Department(
                resultSet.getString("department_name"),
                resultSet.getString("department_description")
        );
    }

    private void setDepartmentParameters(PreparedStatement statement, Department department) throws SQLException {
        statement.setString(1, department.getDepartmentName());
        statement.setString(2, department.getDepartmentDescription());
    }
}
