package com.example.casestudymd3.model;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class CartDAO implements ICartDAO{

    String url = "jdbc:mysql://localhost:3306/shopgame?gamesSSL=false";
    String username = "root";
    String password = "Trung123@";

    protected Connection getConnect() {

        Connection connection = null;
        try {
            //Đăng ký driver
            Class.forName("com.mysql.jdbc.Driver");
            //Kết nối cơ sở dữ liệu
            connection = getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static final String INSERT = "create table cart(\n" +
            "id int auto_increment primary key,\n" +
            "username varchar(255) not null,\n" +
            "name varchar(255) not null,\n" +
            "title varchar(255) not null,\n" +
            "price int not null\n" +
            ");" +
            "INSERT INTO cart (username, name, title, price)" +
            "SELECT u.username, u.name, g.title, g.price" +
            "FROM user u" +
            "JOIN orders o ON u.id = o.user_id" +
            "JOIN orderdetail od ON od.order_id = o.id" +
            "JOIN games g ON g.id = od.game_id" +
            "where u.username = ?;" +
            "SELECT * FROM cart WHERE username = 'trung123'";


    @Override
    public List<Cart> selectCart(String username) {

        ArrayList<Cart> cartlist = new ArrayList<>();

        try (Connection connection = getConnect();

             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, username);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String usernames = rs.getString("username");
                String name = rs.getString("name");
                String title = rs.getString("title");
                int price = rs.getInt("price");

                Cart cart = new Cart(usernames,name,title,price);
                cartlist.add(cart);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cartlist;
    }

    @Override
    public boolean deleteCart() {
        return false;
    }
}
