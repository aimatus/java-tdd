package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
  public static final String URL = "jdbc:mysql://localhost:3306/java-tdd";
  public static final String USER = "root";
  public static final String PASS = "1234";

  public static Connection getConnection() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      return DriverManager.getConnection(URL, USER, PASS);
    } catch (SQLException | ClassNotFoundException ex) {
      throw new RuntimeException("Error connecting to the database", ex);
    }
  }
}
