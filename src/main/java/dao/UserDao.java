package dao;

import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
  private Connection databaseConnection;

  public UserDao(Connection databaseConnection) {
    this.databaseConnection = databaseConnection;
  }

  public List<User> getAllUsers() throws SQLException {
    Statement statement = databaseConnection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
    List<User> users = new ArrayList<>();
    while (resultSet.next()) {
      User user = new User();
      user.setId(resultSet.getInt("id"));
      user.setFullName(resultSet.getString("full_name"));
      user.setUsername(resultSet.getString("username"));
      user.setEmail(resultSet.getString("email"));
      user.setPassword(resultSet.getString("password"));
      users.add(user);
    }
    return users;
  }
}
