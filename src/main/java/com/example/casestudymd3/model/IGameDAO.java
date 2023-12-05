package com.example.casestudymd3.model;

import java.sql.SQLException;
import java.util.List;

public interface IGameDAO {
    public void insertGame(Game game);
    public Game selectGame(int id);
    public List<Game> selectAllGame();
    public boolean deleteGame(int id) throws SQLException;
    public boolean updateGame(Game game) throws SQLException;
}
