package com.thmub.shop.dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class BaseDao {
    protected static final String driverClass = "com.mysql.jdbc.Driver";
    protected static final String jdbcURL = "jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=UTF-8";
    protected static final String user = "root";// modify the user name with yours in mysql
    protected static final String pwd = "zas19960607zyr";// modify the password with yours in mysql

    //获取数据库连接
    public static Connection getConnection() throws Exception {
        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(jdbcURL, user, pwd);
        return conn;
    }
}
