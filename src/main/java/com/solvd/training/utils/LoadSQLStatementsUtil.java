package com.solvd.training.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadSQLStatementsUtil {

    private static final Properties SQL_STATEMENTS;

    static {
        try (InputStream inputStream = LoadSQLStatementsUtil.class.getClassLoader().getResourceAsStream("sql-statements.sql")) {
            if (inputStream == null) {
                throw new IOException("Could not find sql-statements.sql file");
            }

            Properties properties = new Properties();
            properties.load(inputStream);
            SQL_STATEMENTS = properties;
        } catch (IOException e) {
            throw new RuntimeException("Error loading SQL statements", e);
        }
    }

    public static String getSQLStatement(String statementName) {
        return SQL_STATEMENTS.getProperty(statementName);
    }
}
