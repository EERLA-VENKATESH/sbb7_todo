package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    static Connection con;

    public static Connection getConn() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            String url = "jdbc:mysql://localhost:3306/sbb6_todo?useSSL=false&serverTimezone=UTC";
            String user = "root"; 
            String password = ""; 

            
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("Error: MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: Unable to connect to the database!");
            e.printStackTrace();
        }
        return con;
    }

    // Main method to test the connection
    public static void main(String[] args) {
        Connection conn = getConn();
        if (conn != null) {
            System.out.println("Connection Successful!");
        } else {
            System.out.println("Connection Failed!");
        }
    }
}
