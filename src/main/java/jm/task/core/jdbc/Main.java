package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserDao user = new UserServiceImpl();
        user.createUsersTable();
        user.saveUser("Alex","Zaycev", (byte) 24);
        user.saveUser("Max","Smirnov", (byte) 36);
        user.saveUser("Anna","Ivanov", (byte) 66);
        user.saveUser("Inna","Mavchuk", (byte) 35);
        System.out.println(user.getAllUsers());
        user.cleanUsersTable();
        user.dropUsersTable();
        // реализуйте алгоритм здесь
    }
}
