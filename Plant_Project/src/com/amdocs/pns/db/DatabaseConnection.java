package com.amdocs.pns.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                // Load the MySQL JDBC driver
                Class.forName("oracle.jdbc.OracleDriver"); // Registration
                System.out.println("Inside try after class.forname");
                conn = DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:orcl", "scott", "tiger");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
