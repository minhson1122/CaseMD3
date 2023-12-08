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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchGame = request.getParameter("searchGame");
        if (searchGame != null && !searchGame.isEmpty()) {
            List<Game> games = gameDAO.getGamesBySearch(searchGame);
            request.setAttribute("games", games);
        } else {
            List<Game> games = gameDAO.selectAllGame();
            request.setAttribute("games", games);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
