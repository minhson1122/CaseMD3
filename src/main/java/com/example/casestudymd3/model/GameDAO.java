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
    String url = "jdbc:mysql://localhost:3306/shopgame?gamesSSL=false";
    String username = "root";
    String password = "Trung123@";

    private static final String DELETE_GAME_SQL = "DELETE FROM games WHERE id = ?;";
    private static final String UPDATE_GAME_SQL = "update games set title = ?, price = ?,description = ?, genre = ?, rating = ?, totaldownload = ? , developer = ?, releasedate = ? where id = ?";
    private static final String INSERT_GAME_SQL = "INSERT INTO games (title,price,description,genre,rating,developer,releasedate) VALUES (?, ?, ?,?,?,?,?);";
    private static final String SELECT_GAME_BY_ID = "select title,price,description,genre,rating,totaldownload,developer,releasedate FROM games WHERE id =?";
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
        System.out.println(INSERT_GAME_SQL);
        try (Connection connection = getConnect(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GAME_SQL)) {
            preparedStatement.setString(1, game.getTitle());
            preparedStatement.setInt(2, game.getPrice());
            preparedStatement.setString(3, game.getDescription());
            preparedStatement.setString(4, game.getGenre());
            preparedStatement.setString(5, game.getRating());
            preparedStatement.setString(6, game.getDeveloper());
            preparedStatement.setString(7, game.getReleaseDate());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Game selectGame(int id) {
        Game game = null;
        try(
                Connection connection = getConnect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GAME_BY_ID);)

        {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String title = rs.getString("title");
                int price = rs.getInt("price");
                String description = rs.getString("description");
                String genre = rs.getString("genre");
                String rating = rs.getString("rating");
                int totalDownload = rs.getInt("totalDownload");
                String developer = rs.getString("developer");
                String releasDate = rs.getString("releasedate");
                game = new Game(title, price, description, genre, rating, totalDownload, developer, releasDate);

            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return game;
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
                String Rating = rs.getString("Rating");
                int Totaldowload = rs.getInt("TotalDownload");
                String Developer = rs.getString("Developer");
                String ReleaseDate = rs.getString("ReleaseDate");
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
            statement.setString(5, game.getRating());
            statement.setInt(6, game.getTotalDownload());
            statement.setString(7, game.getDeveloper());
            statement.setString(8, game.getReleaseDate());
            statement.setInt(9,game.getId());
            System.out.println(statement);
            rowUpdated = statement.executeUpdate() > 0;
            System.out.println("OK");
        }
        return rowUpdated;
    }

    @Override
    public List<Game> search(String key) {
        // viet cau lenh SQL;
        List<Game> games = new ArrayList<Game>();
        try {
            Connection conn = getConnect();
            String sql = "SELECT * FROM users WHERE name LIKE ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, '%' + key + '%');
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                String title = rs.getString(1);
                int price = Integer.parseInt(rs.getString(2));
                String description = rs.getString(3);
                String genre = rs.getString(4);
                String rating = rs.getString(5);
                String totalDownload = rs.getString(6);
                String developer = rs.getString(7);

                Game game = new Game( title, price, description, genre, rating,totalDownload,developer);
                games.add(game);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return games;
    }
}
