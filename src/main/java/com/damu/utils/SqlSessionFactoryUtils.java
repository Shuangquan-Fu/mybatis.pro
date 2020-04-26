package com.damu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {
    private static String RESOURCE = "mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory;
    //ThreadLocal 是每个线程独立的资源
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    public static void initSqlSessionFactory() throws IOException {
        InputStream is = Resources.getResourceAsStream(RESOURCE);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }


    public static void close(){
        SqlSession session = threadLocal.get();
        if(session != null){
            session.close();
            threadLocal.set(null);
        }
    }
}
