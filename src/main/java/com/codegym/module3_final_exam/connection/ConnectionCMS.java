package com.codegym.module3_final_exam.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCMS {
    public static Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/studentmanagement";
        String jdbcUsername = "root";
        String jdbcPassword = "123456";
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("Connection successfully");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}
