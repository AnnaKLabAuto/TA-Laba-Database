package com.solvd.training.dao.impl;

import com.solvd.training.connections.CustomConnection;
import com.solvd.training.dao.ITemplateDAO;
import com.solvd.training.exceptions.CustomException;
import com.solvd.training.model.Employee;

import static com.solvd.training.utils.LoggerUtil.log;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class EmployeeDAO implements ITemplateDAO {

    private static final Properties SQL_STATEMENTS = loadSqlStatements();

    CustomConnection customConnection = new CustomConnection();

    public EmployeeDAO() throws CustomException {
    }

    private static Properties loadSqlStatements() {
        Properties properties = new Properties();
        try (InputStream input = EmployeeDAO.class.getClassLoader().getResourceAsStream("sql-statements.properties")) {
            properties.load(input);
        } catch (IOException e) {
            log.error(e);
        }
        return properties;
    }

    @Override
    public void create(Employee employee) throws SQLException {
        Connection connection = customConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_STATEMENTS.getProperty("sql.create_employee"))) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getJobTitle());
            preparedStatement.setDouble(6, employee.getSalary());
            preparedStatement.setBoolean(7, employee.isProjectManager());
            preparedStatement.setInt(8, employee.getEmploymentStatusesId());
            preparedStatement.setInt(9, employee.getLeaveTypesId());
            preparedStatement.setInt(10, employee.getDepartmentsId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateById(int id, Employee employee) throws SQLException {
        Connection connection = customConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_STATEMENTS.getProperty("sql.update_by_id_employee"))) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getJobTitle());
            preparedStatement.setDouble(6, employee.getSalary());
            preparedStatement.setBoolean(7, employee.isProjectManager());
            preparedStatement.setInt(8, employee.getEmploymentStatusesId());
            preparedStatement.setInt(9, employee.getLeaveTypesId());
            preparedStatement.setInt(10, employee.getDepartmentsId());
            preparedStatement.setInt(11, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void deleteById(int id) throws SQLException {
        Connection connection = customConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_STATEMENTS.getProperty("sql.delete_by_id_employee"))) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee findById(int id) throws SQLException {
        Connection connection = customConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_STATEMENTS.getProperty("sql.find_employee_by_id"))) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapEmployee(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Employee mapEmployee(ResultSet resultSet) throws SQLException {
        return new Employee(
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email"),
                resultSet.getString("phone"),
                resultSet.getString("job_title"),
                resultSet.getDouble("salary"),
                resultSet.getBoolean("is_project_manager"),
                resultSet.getInt("employment_statuses_id"),
                resultSet.getInt("leave_types_id"),
                resultSet.getInt("departments_id")
        );
    }
}
