package com.solvd.training.connections;

import com.solvd.training.utils.ConnectionUtil;

import static com.solvd.training.utils.LoggerUtil.log;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class CustomConnection {

    private static ConnectionConfig connectionConfig;

    static {
        try {
            ConnectionUtil connectionUtil = new ConnectionUtil();
            String url = connectionUtil.getProperty("jdbc.url");
            String username = connectionUtil.getProperty("jdbc.username");
            String password = connectionUtil.getProperty("jdbc.password");

            connectionConfig = ConnectionConfig.create(url, username, password);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return connectionConfig.getConnection();
    }
}
