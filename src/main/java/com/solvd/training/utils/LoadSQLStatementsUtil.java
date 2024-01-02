package com.solvd.training.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadSQLStatementsUtil {
    private static final Properties SQL_STATEMENTS;

    static {
        Properties properties = new Properties();
        try (InputStream input = LoadSQLStatementsUtil.class.getClassLoader().getResourceAsStream("sql-statements.properties")) {
            properties.load(input);
            SQL_STATEMENTS = properties;
        } catch (IOException e) {
            throw new RuntimeException("Error loading SQL statements", e);
        }
    }

    public static String getSQLStatement(String statementName) {
        return SQL_STATEMENTS.getProperty(statementName);
    }
}
