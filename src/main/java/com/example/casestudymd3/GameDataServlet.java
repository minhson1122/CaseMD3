package com.example.casestudymd3;

import com.example.casestudymd3.model.Game;
import com.example.casestudymd3.model.GameDAO;
import com.example.casestudymd3.model.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name="GameDataServlet", urlPatterns = "/admin/listgamedata")
public class GameDataServlet extends HttpServlet {

    private GameDAO gameDAO;

    @Override
    public void init() throws ServletException {
        try {
            gameDAO = new GameDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        ArrayList<Game> games = new ArrayList<Game>();
        games = (ArrayList<Game>) this.gameDAO.selectAllGame();
        req.setAttribute("games", games);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/listgame.jsp");
        requestDispatcher.forward(req, resp);
    }

    // dẫn đến trang tạo mới
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Game/create.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Game game = gameDAO.selectGame(id);
        request.setAttribute("game", game);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Game/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteGame(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        gameDAO.deleteGame(id);

        List<Game> listGame = gameDAO.selectAllGame();
        request.setAttribute("listGame", listGame);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/listgame.jsp");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Game/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateGame(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String title = request.getParameter("title");
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        String genre = request.getParameter("genre");
        String rating = request.getParameter("rating");
        int totalDownload = Integer.parseInt(request.getParameter("totalDownload"));
        String developer = request.getParameter("developer");
        String releasDate = request.getParameter("releasedate");
        boolean purchased = request.getParameter("purchased").isEmpty();

        Game newGameUpdate = new Game(title, price, description, genre, rating, totalDownload, developer, releasDate, purchased);
        gameDAO.updateGame(newGameUpdate);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Game/edit.jsp");
        dispatcher.forward(request, response);
    }
}
