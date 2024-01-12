 package com.solvd.training.dao.jdbc.impl;

import com.solvd.training.connections.CustomConnection;
import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.exceptions.DbAccessException;
import com.solvd.training.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.training.utils.LoggerUtil.log;

 public class EmployeeDAO implements IBaseDAO<Employee> {

    private final CustomConnection customConnection = new CustomConnection();
    private static final String CREATE_EMPLOYEE_SQL = "INSERT INTO employees (first_name, last_name, email, phone, job_title, salary, is_project_manager, employment_status_id, leave_type_id, department_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE employees SET first_name=?, last_name=?, email=?, phone=?, job_title=?, salary=?, is_project_manager=?, employment_status_id=?, leave_type_id=?, department_id=? WHERE id_employee=?";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM employees WHERE id_employee=?";
    private static final String FIND_EMPLOYEE_SQL = "SELECT * FROM employees WHERE id_employee=?";
    private static final String GET_ALL_EMPLOYEES_SQL = "SELECT id_employee, first_name, last_name, email, phone, job_title, salary, is_project_manager, employment_status_id, leave_type_id, department_id FROM employees";

    private void setEmployeeParameters(PreparedStatement statement, Employee employee) throws SQLException {
        statement.setString(1, employee.getFirstName());
        statement.setString(2, employee.getLastName());
        statement.setString(3, employee.getEmail());
        statement.setString(4, employee.getPhone());
        statement.setString(5, employee.getJobTitle());
        statement.setDouble(6, employee.getSalary());
        statement.setBoolean(7, employee.isProjectManager());
        statement.setInt(8, employee.getEmploymentStatusId());
        statement.setInt(9, employee.getLeaveTypeId());
        statement.setInt(10, employee.getDepartmentId());
    }

    @Override
    public void create(Employee employee) throws DbAccessException {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_EMPLOYEE_SQL)) {
                setEmployeeParameters(preparedStatement, employee);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            log.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
    }

    @Override
    public void update(int id, Employee employee) throws DbAccessException {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {
                setEmployeeParameters(preparedStatement, employee);
                preparedStatement.setInt(11, id);

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
            try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_SQL)) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            log.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
    }

    @Override
    public Employee find(int id) throws DbAccessException {
        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_EMPLOYEE_SQL)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapEmployee(resultSet);
            }
        } catch (SQLException e) {
            log.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
        return null;
    }

    @Override
    public List<Employee> getAll() throws DbAccessException {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_EMPLOYEES_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                employees.add(mapEmployee(resultSet));
            }
        } catch (SQLException e) {
            log.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }

        return employees;
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
                resultSet.getInt("employment_status_id"),
                resultSet.getInt("leave_type_id"),
                resultSet.getInt("department_id")
        );
    }
}
