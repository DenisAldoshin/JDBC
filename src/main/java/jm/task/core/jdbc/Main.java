package jm.task.core.jdbc;



import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {


        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        if (Util.getConnection() != null) {
            System.out.println("connection on");

            userService.dropUsersTable();

            userService.saveUser("Pavel", "Pavlovich", (byte) 56);
            userService.removeUserById(1);
            userService.getAllUsers();
            userService.cleanUsersTable();
            Util.closeConnection(Util.getConnection());


        }
    }
}
