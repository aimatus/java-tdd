package dao;

import model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDaoTest {
    @Mock
    Connection connection;
    @Mock
    Statement statement;
    @Mock
    ResultSet resultSet;

    @Test
    void returnsEmptyListIfThereAreNoUsers() throws SQLException {
        // Arrange
        when(resultSet.next()).thenReturn(false);
        when(statement.executeQuery("SELECT * FROM user")).thenReturn(resultSet);
        when(connection.createStatement()).thenReturn(statement);
        UserDao userDao = new UserDao(connection);

        // Act
        List<User> result = userDao.getAllUsers();

        // Assert
        assertTrue(result.isEmpty());
    }
}
