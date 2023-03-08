package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        UserDao user = new UserDaoJDBCImpl();
        user.createUsersTable();
        user.saveUser("Alex","Bi", (byte) 24);
        user.saveUser("Max","Vil", (byte) 36);
        user.saveUser("Anna","Zapor", (byte) 66);
        user.saveUser("Inna","Mavchuk", (byte) 35);
        System.out.println(user.getAllUsers());
        user.cleanUsersTable();
        user.dropUsersTable();
        // реализуйте алгоритм здесь
    }
}
