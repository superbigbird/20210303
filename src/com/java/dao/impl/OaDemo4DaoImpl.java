package com.java.dao.impl;

import com.java.entity.Dept;
import com.java.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 作者:丁鹏
 * QQ:2431475266
 * 描述:使用dbutil框架来做增、删、改、查操作
 */
public class OaDemo4DaoImpl {
    private  QueryRunner qr = new QueryRunner(JdbcUtil.dataSource);
    /**
     * 添加
     */
    @Test
    public void insertOne() throws SQLException {
        //构建DbUtil框架的核心类:qr，此类中提供了修改与查询方法
        int i = qr.update("INSERT INTO dept VALUES(50,'Java部门','武汉')");
        System.out.println("i = " + i);
    }

    /**
     * 删除
     */
    @Test
    public void deleteOne() throws SQLException {
        //构建DbUtil框架的核心类:qr，此类中提供了修改与查询方法
        int i = qr.update("DELETE FROM dept WHERE deptno=50");
        System.out.println("i = " + i);
    }

    /**
     * 修改
     */
    @Test
    public void updateOne() throws SQLException {
        //构建DbUtil框架的核心类:qr，此类中提供了修改与查询方法
        int i = qr.update("UPDATE dept SET loc='长沙' WHERE deptno=50");
        System.out.println("i = " + i);
    }

    /**
     * 查询1条数据
     */
    @Test
    public void selectOne() throws SQLException {
        //query(String sql,ResultSetHandler<T>)
        /**
         * ResultSetHandler：结果集处理器
         */
        //告诉DbUtil框架，使用Map<String,Object>来装一条数据记录
        Map<String,Object> oneMap = qr.query("SELECT * FROM dept WHERE deptno='10' ", new MapHandler());
        //使用实体类对象
        Dept dpt = qr.query("SELECT * FROM dept WHERE deptno='10' ", new BeanHandler<Dept>(Dept.class));
        //使用Object数组来装
        Object[] objArr = qr.query("SELECT * FROM dept WHERE deptno='10' ", new ArrayHandler());
        System.out.println(Arrays.toString(objArr));

    }

    /**
     * 查询多条数据
     */
    @Test
    public void selectMany() throws SQLException {
        //使用List<Map<String,Object>来封装数据
        List<Map<String, Object>> dept1List = qr.query("SELECT * FROM dept", new MapListHandler());
        //使用List<Dept>来封装数据
        List<Dept> dept2List = qr.query("SELECT * FROM dept", new BeanListHandler<Dept>(Dept.class));
        //使用List<Object[]>来封装数据
        List<Object[]> dept3List = qr.query("SELECT * FROM dept", new ArrayListHandler());
        dept3List.forEach(temp->{
            System.out.println(Arrays.toString(temp));
        });
    }
}
