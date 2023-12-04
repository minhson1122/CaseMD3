package com.example.casestudymd3.model;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user);
    public User selectUser(int id);
    public List<User> selectAllUser();
    public boolean deleteUser(int id);
    public boolean updateUser(User user);
}
