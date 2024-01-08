package com.solvd.training.dao;

import com.solvd.training.dao.mybatis.IEmployeeDAO;
import org.apache.ibatis.binding.MapperRegistry;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DAOConfig {

    private static final SqlSessionFactory sessionFactory;

    static {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml")) {
            sessionFactory = new SqlSessionFactoryBuilder()
                    .build(is);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
