package com.solvd.training.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.training.utils.LoggerUtil.LOGGER;

public class ConnectionConfig implements ConnectionPool{

    private String url;
    private String user;
    private String password;
    private List<Connection> connectionPool;
    private List<Connection> usedConnection = new ArrayList<>();
    public static final int INITIALIZE_POOL_SIZE = 10;
    private final int MAX_POOL_SIZE = 20;

    public ConnectionConfig(String url, String user, String password, List<Connection> connectionPool) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = connectionPool;
    }

    public static ConnectionConfig create(String url, String user, String password) throws SQLException {
        List<Connection> pool = new ArrayList<>(INITIALIZE_POOL_SIZE);
        for (int i = 0; i < INITIALIZE_POOL_SIZE; i++) {
            pool.add(createConnection(url, user, password));
        }
        return new ConnectionConfig(url, user, password, pool);
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (connectionPool.isEmpty()) {
            if(usedConnection.size() < MAX_POOL_SIZE) {
                connectionPool.add(createConnection(url, user, password));
            } else {
                throw new RuntimeException("Maximum pool size reached");
            }
        }
        Connection connection = connectionPool
                .remove(connectionPool.size() - 1);
        usedConnection.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        synchronized (this) {
            connectionPool.add(connection);
            return usedConnection.remove(connection);
        }
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException{
        Connection connection = DriverManager.getConnection(url, user, password);
        if(connection != null){
            LOGGER.info("Successfully connected");
        } else {
            LOGGER.error("Failed to connect");
            throw new SQLException("Failed to connect");
        }
        return connection;
    }
}
