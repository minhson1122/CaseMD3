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
import java.util.ArrayList;

@WebServlet(name = "ShopGameServlet",urlPatterns = "/home")

public class ShopGameServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GameDAO gameDAO = new GameDAO();
        ArrayList<Game> games = (ArrayList<Game>) gameDAO.selectAllGame();

        req.setAttribute("games", games);

        RequestDispatcher view = req.getRequestDispatcher("/home.jsp");
        view.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
