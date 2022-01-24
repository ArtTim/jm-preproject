package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        Util connect = new Util();
        String query = "CREATE TABLE Users (" +
                "  `id` INT NOT NULL AUTO_INCREMENT," +
                "  `name` VARCHAR(45) NOT NULL," +
                "  `last_name` VARCHAR(45) NULL," +
                "  `age` INT NOT NULL," +
                "  PRIMARY KEY (`id`));";
        try {
            Statement statement = connect.getConnection().createStatement();
//             System.out.println(statement.executeQuery(checkQuery));
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        Util connect = new Util();
        try {
            Statement statement = connect.getConnection().createStatement();
            statement.executeUpdate("DROP TABLE Users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
