package edu.northeastern.cs5200;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String URL = "jdbc:mysql://cs5200-spring2019-bhosale.cn42l2ub7lem.us-east-2.rds.amazonaws.com/cs5200_jdbc";
  private static final String USER = "anaghab";
  private static final String PASSWORD = "Newuser123";
  private static Connection dbConnection = null;

  public static Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName(DRIVER);

    if (dbConnection == null) {
      dbConnection = DriverManager.getConnection(URL, USER, PASSWORD);
      return dbConnection;
    } else { return dbConnection; } }

  public static void closeConnection() {
    try {
      if (dbConnection != null) {
        dbConnection.close();
        dbConnection = null; }
    } catch (SQLException e) {
      System.out.println("Failed to close connection");
      e.printStackTrace();
    }
  }

}
