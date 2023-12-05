package com.example.casestudymd3.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class GameDAO implements IGameDAO {
    String url = "jdbc:mysql://localhost:3306/shopgame?userSSL=false";
    String username = "root";
    String password = "tomtep123";

    private static final String DELETE_GAME_SQL = "delete from game where id = ?;";
    private static final String UPDATE_GAME_SQL = "update game set title = ?, price = ?,description = ?, genre = ?, rating = ?, TotalDownload = ? , Developer = ?, releaseDate = ?, purchased = ? where id = ?;";

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


    @Override
    public void insertGame(Game game) {

    }

    @Override
    public Game selectGame(int id) {
        return null;
    }

    @Override
    public List<Game> selectAllGame() {
        ArrayList<Game> gamelist = new ArrayList<>();


        try (Connection connection = getConnect();

             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM games")) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int price = rs.getInt("price");
                String Description = rs.getString("Description");
                String Genre = rs.getString("Genre");
                double Rating = rs.getDouble("Rating");
                int Totaldowload = rs.getInt("TotalDownload");
                String Developer = rs.getString("Developer");
                Date ReleaseDate = rs.getDate("ReleaseDate");
                boolean Purchased = rs.getBoolean("Purchased");
                Game game = new Game(id, title, price, Description, Genre, Rating, Totaldowload, Developer, ReleaseDate, Purchased);
                gamelist.add(game);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return gamelist;
    }

    @Override
    public boolean deleteGame(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnect(); PreparedStatement statement = connection.prepareStatement(DELETE_GAME_SQL );) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateGame(Game game) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnect(); PreparedStatement statement = connection.prepareStatement(UPDATE_GAME_SQL);) {
            statement.setString(1, game.getTitle());
            statement.setInt(2, game.getPrice());
            statement.setString(3, game.getDescription());
            statement.setString(4, game.getGenre());
            statement.setDouble(5, game.getRating());
            statement.setInt(6, game.getTotalDownload());
            statement.setString(7, game.getDeveloper());
            statement.setDate(8, game.getReleaseDate());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
