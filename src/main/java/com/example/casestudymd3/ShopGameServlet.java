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
        GameDAO gameDAO = new GameDAO();
        ArrayList<Game> games = (ArrayList<Game>) gameDAO.selectAllGame();
        req.setAttribute("games", games);
        RequestDispatcher view = req.getRequestDispatcher("/home.jsp");
        view.forward(req,resp);

        showListUser(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void showListUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Game> data;
        if (keyword == null) {
            data =  this.gameDAO.selectAllGame();
        } else {
            data =  this.gameDAO.search(keyword);
        }
        req.setAttribute("keyword", keyword);
        req.setAttribute("users", data);
        RequestDispatcher view = req.getRequestDispatcher("/home");
        view.forward(req, resp);
    }
}
