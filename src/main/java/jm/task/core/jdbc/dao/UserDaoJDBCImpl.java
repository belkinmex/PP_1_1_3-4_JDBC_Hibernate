package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }
    @Override
    public void createUsersTable() {
        try (Connection connection= Util.getMySQLConnection()){
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS users(id int primary key auto_increment, name varchar(40), lastName varchar(40), age int )");
            System.out.println("таблица создана");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void dropUsersTable() {
        try (Connection connection= Util.getMySQLConnection()){
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS users");
            System.out.println("таблица удалена");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void saveUser(String name, String lastName, byte age) {
        final String INSERT = ("INSERT INTO users (name, lastname, age)"+"VALUES (?,?,?)");
        try (Connection connection= Util.getMySQLConnection(); PreparedStatement statement = connection.prepareStatement(INSERT)){
            statement.setString(1,name);
            statement.setString(2,lastName);
            statement.setByte(3,age);
            statement.execute();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void removeUserById(long id) {
        final String DELETE = ("DELETE FROM users WHERE id = ?");
        try (Connection connection= Util.getMySQLConnection(); PreparedStatement statement = connection.prepareStatement(DELETE)){
            statement.setString(1, String.valueOf(id));
            statement.execute();
            System.out.println("user удален с id"+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<User> getAllUsers() {
        List <User> users = new ArrayList<>();
        try (Connection connection= Util.getMySQLConnection();Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                byte age = resultSet.getByte("age");
                User user = new User(name,lastName,age);
                user.setId(id);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
    @Override
    public void cleanUsersTable() {
        try (Connection connection= Util.getMySQLConnection()){
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM users");
            System.out.println("таблица очищена");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

