package com.example.casestudymd3.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class UserDAO implements IUserDAO {
    String url = "jdbc:mysql://localhost:3306/shopgame?userSSL=false";
    String username = "root";
    String password = "kiseki99!!";

    private static final String INSERT_USER_SQL = "INSERT INTO user(name,email,address,username,password,role) VALUES (?,?,?,?,?,?)";
    private static final String SELECT_USER_BY_ID = "SELECT id,name,email,address,username,password,role FROM user WHERE id = ?";
    private static final String SELECT_USER_ALL = "SELECT * FROM user";
    private static final String DELETE_USER_SQL = "DELETE FROM user WHERE id = ?";
    private static final String UPDATE_USER_SQL = "UPDATE user SET name = ?, email = ?, address = ?,username = ?,password = ?,role = ? WHERE id = ?";
    private static final String UPDATE_USER_SQL_BY_USERNAME = "UPDATE user SET name = ?, address = ?,password = ? WHERE username = ?";



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
            statement.setString(6,user.getRole());
            statement.executeUpdate();
            System.out.println("da them thanh cong");
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
                String role = rs.getString("role");
                user = new User(id,name,email, address, username, password,role);

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
                String role = rs.getString("role");

                users.add(new User(id,name,email, address, username, password,role));
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
            statement.setString(6, user.getRole());
            statement.setInt(7,user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean updateUserByName(String name,String address,String username,String password) throws SQLException {


        try (Connection connection = getConnect();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL_BY_USERNAME)) {
            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, email);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, username);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0; // Trả về true nếu có ít nhất một dòng được cập nhật
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkUser(String username, String password) throws SQLException {
        try (Connection connection = getConnect();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE username = '" + username + "' AND password='" + password + "'");) {
            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean checkRegister(String email,String username) throws SQLException {

        try (Connection connection = getConnect();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE email = '" + email + "' OR username='" + username + "'");) {
            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean checkAccountAdmin(String username,String password,String role) throws SQLException {
        try (Connection connection = getConnect();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE username = '" + username + "' AND password= '"+ password + "' AND role = 'admin'");) {
            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM user WHERE username = ?";
        try (PreparedStatement preparedStatement = getConnect().prepareStatement(sql)) {
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Lấy thông tin người dùng từ ResultSet và trả về
                    User user = new User();
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setAddress(resultSet.getString("address"));
                    user.setUserName(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));

                    // Thêm các thông tin khác tương ứng

                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Trả về null nếu không tìm thấy người dùng
    }

    public void closeConnection() {
        Connection connection = null;
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
