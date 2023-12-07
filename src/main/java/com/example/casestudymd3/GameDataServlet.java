package com.example.casestudymd3;

import com.example.casestudymd3.model.Game;
import com.example.casestudymd3.model.GameDAO;
import com.example.casestudymd3.model.User;
import com.example.casestudymd3.model.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="GameDataServlet", urlPatterns = "/admin/listgamedata")
public class GameDataServlet extends HttpServlet {

    private GameDAO gameDAO;

    @Override
    public void init() throws ServletException {
        gameDAO = new GameDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(req, resp);
                break;
            case "update":
                try {
                    showEditForm(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                try {
                    deleteGame(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                listGames(req, resp);
                break;
        }
    }

    private void listGames(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Game> games = this.gameDAO.selectAllGame();
        req.setAttribute("games", games);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/game/listgame.jsp");
        requestDispatcher.forward(req, resp);
    }

    // dẫn đến trang tạo mới
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/game/create.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        Game game = gameDAO.selectGame(id);
        request.setAttribute("gameN", game);
        System.out.println(game);
        request.setAttribute("id", id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/game/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteGame(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        gameDAO.deleteGame(id);

        List<Game> listGame = gameDAO.selectAllGame();
        request.setAttribute("listGame", listGame);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/game/listgame.jsp");
//        dispatcher.forward(request, response);
        response.sendRedirect("/admin/listgamedata");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    insertGame(req, resp);
                } catch (SQLException e) {
                    System.out.println("OK");
                    throw new RuntimeException(e);
                }
                break;
            case "update":
                try {
                    updateGame(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                break;
        }
    }

    private void insertGame(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String title = request.getParameter("title");
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        String genre = request.getParameter("genre");
        String rating = request.getParameter("rating");
//        int totalDownload = Integer.parseInt(request.getParameter("totalDownload"));
        String developer = request.getParameter("developer");
        String releaseDate = request.getParameter("releasedate");
//        boolean purchased = request.getParameter("purchased").isEmpty();
        Game newGame = new Game(title, price, description, genre, rating, developer, releaseDate);
        this.gameDAO.insertGame(newGame);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/game/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateGame(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        String genre = request.getParameter("genre");
        String rating = request.getParameter("rating");
        int totalDownload = Integer.parseInt(request.getParameter("totaldownload"));
        String developer = request.getParameter("developer");
        String releaseDate = request.getParameter("releasedate");

        Game newGameUpdate = new Game(id,title, price, description, genre, rating, totalDownload, developer, releaseDate);
        gameDAO.updateGame(newGameUpdate);
        request.setAttribute("message","Da sua thanh cong !");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/game/edit.jsp");
        dispatcher.forward(request, response);
    }
}
