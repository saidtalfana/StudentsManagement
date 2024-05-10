package com.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {
	public static String jdbcURL = "jdbc:mysql://localhost:3306/st";
    public static String jdbcUserName = "root";
    public static String jdbcPassword = "";
  //  public static String jdbcDriver = "com.mysql.cj.jdbc.Driver";


    public static Connection getConnection() {
        Connection connection = null;
        try {
          connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    
    }
}
