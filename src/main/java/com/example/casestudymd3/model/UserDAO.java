package com.example.casestudymd3.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class UserDAO implements IUserDAO {
    String url = "jdbc:mysql://localhost:3306/shopgame?userSSL=false";
    String username = "root";
    String password = "Trung123@";

    private static final String INSERT_USER_SQL = "INSERT INTO user(name,email,address,username,password) VALUES (?,?,?,?,?)";
    private static final String SELECT_USER_BY_ID = "SELECT id,name,email,address,username,password FROM user WHERE id = ?";
    private static final String SELECT_USER_ALL = "SELECT * FROM user";
    private static final String DELETE_USER_SQL = "DELETE FROM user WHERE id = ?";
    private static final String UPDATE_USER_SQL = "UPDATE user SET name = ?, email = ?, address = ?,username = ?,password = ? WHERE id = ?";


    protected Connection getConnect(){

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = getConnection(url, username, password);
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
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getAddress());
            statement.setString(4,user.getUserName());
            statement.setString(5,user.getPassword());
            statement.executeUpdate();
            System.out.println("da them thanhc cong");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try (Connection connection = getConnect();
             PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ID);
        ) {
            statement.setInt(1,id);
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String username = rs.getString("username");
                String password = rs.getString("password");
                user = new User(id,name,email, address, username, password);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }


    @Override
    public List<User> selectAllUser() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnect();
             PreparedStatement statement = connection.prepareStatement(SELECT_USER_ALL);
        ) {
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String username = rs.getString("username");
                String password = rs.getString("password");
                users.add(new User(id,name,email, address, username, password));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnect();
             PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);
        ){
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnect();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getUserName());
            statement.setString(5, user.getPassword());
            statement.setInt(6,user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }


}
