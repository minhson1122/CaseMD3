package com.example.casestudymd3;

import com.example.casestudymd3.model.User;
import com.example.casestudymd3.model.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet",urlPatterns = "/account/register")
public class registerServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("/register.jsp");
        view.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            String username = req.getParameter("username");
//            String email = req.getParameter("email");
//
//
//            User user = new User(name, phone, email, address, username, password);
//            user.setUserName(username);
//            user.setEmail(email);
//
//            UserDAO userDAO = new UserDAO();


    }
}
