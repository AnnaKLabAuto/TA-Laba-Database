package com.solvd.training.connections;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {

    public Connection getConnection() throws SQLException;

    public boolean releaseConnection(Connection connection);

}
