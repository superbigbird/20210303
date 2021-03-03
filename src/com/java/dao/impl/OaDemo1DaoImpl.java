package com.java.dao.impl;

import com.java.utils.JdbcUtilV1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 作者:丁鹏
 * QQ:2431475266
 * 描述:使用JDBC对mysql进行CRUD(增删改查)操作
 */
public class OaDemo1DaoImpl {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        long startTime = System.currentTimeMillis();
        //1、导入MySQL驱动  已完成
        //2、加载MySQL驱动
        Class.forName(JdbcUtilV1.driverClassName);
        //3、在java与mysql软件之间建立一座桥梁
        Connection conn = DriverManager.getConnection(JdbcUtilV1.url, JdbcUtilV1.username, JdbcUtilV1.password);
        Statement st = null;
        for (int i=1;i<=100000;i++) {
            //4、造车(Statement)
            String sql = "INSERT INTO users VALUES(null,'张三"+i+"',20)";
            st = conn.createStatement();
            //将sql语句装车，然后开车
            st.executeUpdate(sql);
        }
        //5、炸车、炸桥
        st.close();
        conn.close();
        long endTime = System.currentTimeMillis();
        System.out.println("共消耗"+(endTime-startTime)+"ms");
    }
}
