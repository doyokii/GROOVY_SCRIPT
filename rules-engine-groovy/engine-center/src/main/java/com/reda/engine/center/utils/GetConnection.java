package com.reda.engine.center.utils;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.1.76:3306/zjltest", "foqa", "foqa");
        } catch (Exception e) {
            System.out.println("数据库连接失败" + e.getMessage());
        }
        return con;
    }
}
