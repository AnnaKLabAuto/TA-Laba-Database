 package com.solvd.training.dao.impl;

import com.solvd.training.connections.CustomConnection;
import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.model.Employee;
import com.solvd.training.utils.LoadSQLStatementsUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.training.utils.LoggerUtil.log;


public class EmployeeDAO implements IBaseDAO<Employee> {

    private final LoadSQLStatementsUtil loadSQLStatementsUtil = new LoadSQLStatementsUtil();
    private final CustomConnection customConnection = new CustomConnection();

    @Override
    public void create(Employee entity) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.create_employee"))) {
                preparedStatement.setString(1, entity.getFirstName());
                preparedStatement.setString(2, entity.getLastName());
                preparedStatement.setString(3, entity.getEmail());
                preparedStatement.setString(4, entity.getPhone());
                preparedStatement.setString(5, entity.getJobTitle());
                preparedStatement.setDouble(6, entity.getSalary());
                preparedStatement.setBoolean(7, entity.isProjectManager());
                preparedStatement.setInt(8, entity.getEmploymentStatusId());
                preparedStatement.setInt(9, entity.getLeaveTypeId());
                preparedStatement.setInt(10, entity.getDepartmentId());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
        }
    }

    @Override
    public void update(int id, Employee entity) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.update_by_id_employee"))) {
                preparedStatement.setString(1, entity.getFirstName());
                preparedStatement.setString(2, entity.getLastName());
                preparedStatement.setString(3, entity.getEmail());
                preparedStatement.setString(4, entity.getPhone());
                preparedStatement.setString(5, entity.getJobTitle());
                preparedStatement.setDouble(6, entity.getSalary());
                preparedStatement.setBoolean(7, entity.isProjectManager());
                preparedStatement.setInt(8, entity.getEmploymentStatusId());
                preparedStatement.setInt(9, entity.getLeaveTypeId());
                preparedStatement.setInt(10, entity.getDepartmentId());
                preparedStatement.setInt(11, id);

                preparedStatement.executeUpdate();

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
        }
    }


    @Override
    public void delete(int id) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.delete_by_id_employee"))) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
        }
    }

    @Override
    public Employee find(int id) {
        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.find_employee_by_id"))) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapEmployee(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
        }
        return null;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.get_all_employees"))) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                employees.add(mapEmployee(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
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
