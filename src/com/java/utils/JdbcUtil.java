package com.java.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 作者:丁鹏
 * QQ:2431475266
 * 描述:jdbc最终帮助工具类
 */
public class JdbcUtil {
    public static DataSource dataSource = null;
    static{
        try {
            //构建一个Properties类的对象，对象名为prop。
            Properties prop = new Properties();
            //将jdbc.properties文件变为字节输入流
            InputStream ins = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //将prop对象与jdbc.properties文件进行关联
            prop.load(ins);
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
