package com.example.casestudymd3.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class UserDAO implements IUserDAO {
    String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    String username = "root";
    String password = "tomtep123";

    private static final String INSERT_USER_SQL = "INSERT INTO user(name,phone,email,address,username,password) " +
            "VALUES (?,?,?,?,?,?)";


    protected Connection getConnect(){

        java.sql.Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public void insertUser(User user) {
        System.out.println(INSERT_USER_SQL);
        try (Connection connection = getConnect();
             PreparedStatement statement = connection.prepareStatement(INSERT_USER_SQL)) {
            statement.setString(1,user.getName());
            statement.setString(2,user.getPhone());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getAddress());
            statement.setString(5,user.getUserName());
            statement.setString(6,user.getPassword());
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUser() {
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
