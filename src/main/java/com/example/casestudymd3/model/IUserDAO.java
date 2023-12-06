package com.example.casestudymd3.model;

import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user);
    public User selectUser(int id);
    public List<User> selectAllUser();
    public boolean deleteUser(int id) throws SQLException;
    public boolean updateUser(User user) throws SQLException;
    public boolean checkUser(String username, String password) throws SQLException;
    public boolean checkAccountAdmin(String username,String password,String role) throws SQLException;
    public boolean checkRegister(String email,String username) throws SQLException;
}
