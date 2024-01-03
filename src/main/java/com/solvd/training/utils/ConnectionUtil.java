package com.solvd.training.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionUtil {

    private static final String CONNECTION_PROPERTIES_FILE_PATH = "database.properties";

    private Properties properties;

    public ConnectionUtil() throws IOException {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(CONNECTION_PROPERTIES_FILE_PATH)) {
            if (inputStream == null) {
                throw new IOException("Could not find database.properties file");
            }

            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Error loading database properties", e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}

