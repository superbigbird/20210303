package com.java.dao.impl;

import java.sql.*;

/**
 * 作者:丁鹏
 * QQ:2431475266
 * 描述:使用JDBC对mysql进行查询操作
 */
public class OaDemo2DaoImpl {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、导入MySQL驱动  已完成
        //2、加载MySQL驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3、在java与mysql软件之间建立一座桥梁
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oa?useSSL=false", "root", "root");
        //4、造车(Statement)
        Statement st = conn.createStatement();
        //将sql语句装车，然后开车
        String sql = "SELECT * FROM dept";
        ResultSet rs = st.executeQuery(sql);//ResultSet：结果集
        //1)ResultSet中共有4条数据
        //2)每条数据中有deptno(int(11))、dname(varchar(20))、loc(varchar(20))三个字段
        System.out.println("部门编号\t部门名称\t部门地址");
        while (rs.next()) {
            long deptno = rs.getLong("deptno");
            String dname = rs.getString("dname");
            String loc = rs.getString("loc");
            System.out.println(deptno+"\t"+dname+"\t"+loc);
        }
        //5、炸容器、炸车、炸桥
        rs.close();
        st.close();
        conn.close();
    }
}
