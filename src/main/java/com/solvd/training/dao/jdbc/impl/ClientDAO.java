package com.solvd.training.dao.jdbc.impl;

import com.solvd.training.connections.CustomConnection;
import com.solvd.training.dao.IBaseDAO;
import com.solvd.training.exceptions.DbAccessException;
import com.solvd.training.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.training.utils.LoggerUtil.log;

public class ClientDAO implements IBaseDAO<Client> {

    private final CustomConnection customConnection = new CustomConnection();
    private static final String CREATE_CLIENT_SQL = "INSERT INTO clients (first_name, last_name, email, phone, company, address) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_CLIENT_SQL = "UPDATE clients SET first_name=?, last_name=?, email=?, phone=?, company=?, address=? WHERE id_client=?";
    private static final String DELETE_CLIENT_SQL = "DELETE FROM clients WHERE id_client=?";
    private static final String FIND_CLIENT_SQL = "SELECT * FROM clients WHERE id_client=?";
    private static final String GET_ALL_CLIENTS_SQL = "SELECT id_client, first_name, last_name, email, phone, company, address FROM clients";

    @Override
    public void create(Client client) throws DbAccessException {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CLIENT_SQL)) {
                setClientParameters(preparedStatement, client);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            log.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
    }

    @Override
    public void update(int id, Client client) throws DbAccessException {
        try (Connection connection = customConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENT_SQL)) {
                setClientParameters(preparedStatement, client);
                preparedStatement.setInt(7, id);

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
            try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT_SQL)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            log.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
    }

    @Override
    public Client find(int id) throws DbAccessException {
        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_CLIENT_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return mapResultSetToClient(resultSet);
            }
        } catch (SQLException e) {
            log.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
        return null;
    }

    @Override
    public List<Client> getAll() throws DbAccessException {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = customConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CLIENTS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                clients.add(mapResultSetToClient(resultSet));
            }
        } catch (SQLException e) {
            log.error("Error accessing database: ", e);
            throw new DbAccessException("Error accessing database", e);
        }
        return clients;
    }

    private Client mapResultSetToClient(ResultSet resultSet) throws SQLException {
        return new Client(
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email"),
                resultSet.getString("phone"),
                resultSet.getString("company"),
                resultSet.getString("address")
        );
    }

    private void setClientParameters(PreparedStatement statement, Client client) throws SQLException {
        statement.setString(1, client.getFirstName());
        statement.setString(2, client.getLastName());
        statement.setString(3, client.getEmail());
        statement.setString(4, client.getPhone());
        statement.setString(5, client.getCompany());
        statement.setString(6, client.getAddress());
    }
}
