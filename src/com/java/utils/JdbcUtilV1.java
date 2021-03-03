package com.java.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 作者:丁鹏
 * QQ:2431475266
 * 描述:jdbc帮助工具类
 */
public class JdbcUtilV1 {
    public static String driverClassName = null;
    public static String url = null;
    public static String username=null;
    public static String password=null;

    static{
        try {
            //构建一个Properties类的对象，对象名为prop。
            Properties prop = new Properties();
            //将jdbc.properties文件变为字节输入流
            InputStream ins = JdbcUtilV1.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //将prop对象与jdbc.properties文件进行关联
            prop.load(ins);
            //获取prop这个对象中的数据
            driverClassName = prop.getProperty("driverClassName");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
