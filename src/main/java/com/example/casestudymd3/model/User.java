package com.example.casestudymd3.model;

public class User {
    private int id;
    private String name;
    private String email;
    private String address;
    private String userName;
    private String password;
    private String role;

    public User(int id, String name, String email, String address, String userName, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public User(String name, String email, String address, String userName, String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.userName = userName;
        this.password = password;
    }

    public User(String name, String email, String address, String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public User(String name, String email, String address, String userName, String password, String role) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
