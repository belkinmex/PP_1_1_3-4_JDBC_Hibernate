package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.*;

public class UserServiceImpl implements UserService  {
    UserDao table = new UserDaoHibernateImpl();
    @Override
    public void createUsersTable() {
        table.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        table.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        table.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        table.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {

        return table.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        table.cleanUsersTable();
    }
}