package com.damu.listener;

import com.damu.utils.SqlSessionFactoryUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
//什么是监听器
@WebListener
public class initSqlSessionListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //初始化 factory 对象
        try {
            System.out.println("容器加载中");
            SqlSessionFactoryUtils.initSqlSessionFactory();
        } catch (IOException e) {
            System.out.println("容器创建不成功");
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("容器销毁中");
        SqlSessionFactoryUtils.close();
    }
}
