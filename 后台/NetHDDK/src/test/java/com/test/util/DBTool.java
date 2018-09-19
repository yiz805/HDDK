package com.test.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBTool {
    public static SqlSessionFactory sessionFactory;
    static {
        try {
            // 使用mybatis提供的resource类加载的配置文件
            Reader reader = Resources.getResourceAsReader("applicationContext.xml");
            // 构建Sqlsession工厂
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 创建能执行映射文件中的sqlSession
    public static SqlSession getSession() {
        return sessionFactory.openSession();
    }
}
