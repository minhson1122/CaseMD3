package com.example.casestudymd3;


import com.example.casestudymd3.model.Game;
import com.example.casestudymd3.model.GameDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShopGameServlet",urlPatterns = "/home")

public class ShopGameServlet extends HttpServlet {
    GameDAO gameDAO = new GameDAO();
    @Override
    public void init() throws ServletException {
        gameDAO = new GameDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchGame = req.getParameter("searchGame");
        if (searchGame != null && !searchGame.isEmpty()) {
            List<Game> games = gameDAO.getGamesBySearch(searchGame);
            req.setAttribute("games", games);
        } else {
            List<Game> games = gameDAO.selectAllGame();
            req.setAttribute("games", games);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
