package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private String SAVE_USER = "INSERT INTO Users(name, last_name, age) VALUES (?, ?, ?);";

    public void createUsersTable() {
        Util connect = new Util();
        String query = "CREATE TABLE IF NOT EXISTS Users (" +
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
            statement.executeUpdate("DROP TABLE IF EXISTS Users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Util connect = new Util();
        try {
            PreparedStatement statement = connect.getConnection().prepareStatement(SAVE_USER);
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Util connect = new Util();
        try {
            PreparedStatement statement = connect.getConnection().prepareStatement("SELECT * from Users");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                byte age = rs.getByte("age");
                String name = rs.getString("name");
                String last_name = rs.getString("last_name");
                users.add(new User(name, last_name, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
        Util connect = new Util();
        try {
            Statement statement = connect.getConnection().createStatement();
            statement.execute("DELETE FROM Users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
