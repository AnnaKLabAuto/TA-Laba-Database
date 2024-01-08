package com.solvd.training;

import com.solvd.training.dao.mybatis.IEmployeeDAO;
import com.solvd.training.exceptions.NotFoundException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws NotFoundException {

        try(InputStream is = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
                    .build(is);
            SqlSession sqlSession = sessionFactory.openSession(true);

            IEmployeeDAO iEmployeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
//            iEmployeeDAO.find(1).orElseThrow(() -> new RuntimeException(String.format("Error message", e))) ??

        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}