package com.solvd.training.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

import static com.solvd.training.utils.LoggerUtil.LOGGER;

public class SqlSessionFactoryHolder {

    private static final SqlSessionFactory sessionFactory;

    static {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml")) {
            sessionFactory = new SqlSessionFactoryBuilder()
                    .build(is);
        } catch (IOException e) {
            LOGGER.error("Failed to create SqlSessionFactory");
            throw new RuntimeException(e);
        }
    }

    public static SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
