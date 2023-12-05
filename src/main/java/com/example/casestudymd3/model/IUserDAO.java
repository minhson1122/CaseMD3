package com.example.casestudymd3.model;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user);
    public User selectUser(int id);
    public List<User> selectAllUser();
    public boolean deleteUser(int id) throws SQLException;
    public boolean updateUser(User user) throws SQLException;

    boolean checkUser(String username, String password) throws SQLException;
}
