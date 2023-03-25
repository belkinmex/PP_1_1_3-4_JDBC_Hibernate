package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.*;

public class UserServiceImpl implements UserService  {
    UserDao users = new UserDaoHibernateImpl();
    @Override
    public void createUsersTable() {
        users.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        users.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        users.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        users.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {

        return users.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        users.cleanUsersTable();
    }
}