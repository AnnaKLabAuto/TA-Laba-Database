package com.solvd.training.dao.impl;

import com.solvd.training.connections.CustomConnection;
import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.model.Client;
import com.solvd.training.utils.LoadSQLStatementsUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.solvd.training.utils.LoggerUtil.log;

public class ClientDAO implements IBaseDAO<Client> {

    private final LoadSQLStatementsUtil loadSQLStatementsUtil = new LoadSQLStatementsUtil();
    private final CustomConnection customConnection = new CustomConnection();

    @Override
    public void create(Client entity) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.create_client"))) {
                preparedStatement.setString(1, entity.getFirstName());
                preparedStatement.setString(2, entity.getLastName());
                preparedStatement.setString(3, entity.getEmail());
                preparedStatement.setString(4, entity.getPhone());
                preparedStatement.setString(5, entity.getCompany());
                preparedStatement.setString(6, entity.getAddress());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
        }
    }

    @Override
    public void update(int id, Client entity) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.update_by_id_client"))) {
                preparedStatement.setString(1, entity.getFirstName());
                preparedStatement.setString(2, entity.getLastName());
                preparedStatement.setString(3, entity.getEmail());
                preparedStatement.setString(4, entity.getPhone());
                preparedStatement.setString(5, entity.getCompany());
                preparedStatement.setString(6, entity.getAddress());
                preparedStatement.setInt(7, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.delete_by_id_client"))) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
        }
    }

    @Override
    public Client find(int id) {
        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LoadSQLStatementsUtil.getSQLStatement("sql.find_client_by_id"));
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return mapClient(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing database: ", e);
        }
        return null;
    }

    private Client mapClient(ResultSet resultSet) throws SQLException {
        return new Client(
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email"),
                resultSet.getString("phone"),
                resultSet.getString("company"),
                resultSet.getString("address")
        );
    }
}
