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
import java.util.ArrayList;

@WebServlet(name="GameDataServlet", urlPatterns = "/listgamedata")
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
                break;
            case "edit":
                break;
            case "delete":
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
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
