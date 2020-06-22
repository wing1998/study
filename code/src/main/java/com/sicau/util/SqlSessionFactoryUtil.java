package com.sicau.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sqlSessionFactory = null;

    public SqlSessionFactoryUtil() {
    }

    private static void getSqlSessionFactory(){
        synchronized (SqlSessionFactory.class){
            if (sqlSessionFactory != null){
                return;
            }
            String resource = "mybatis-config.xml";
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static SqlSession getSqlSession(){
        if (sqlSessionFactory == null) {
            getSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }

    public static void closeSqlSession(SqlSession sqlSession){
        try {
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (null != sqlSession){
                sqlSession.close();
            }
        }

    }
}
