package com.example.casestudymd3.AccountModel;

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

@WebServlet(name = "registerServlet",urlPatterns = "/account/register")
public class registerServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        this.userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("/register.jsp");
        view.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        User userNew = new User(name,email,address,username,password,role);

        try {
            if (!userDAO.checkRegister(email,username)){
                req.setAttribute("message","Tao thanh cong !");
                userDAO.insertUser(userNew);
                RequestDispatcher view = req.getRequestDispatcher("/register.jsp");
                view.forward(req,resp);
            }else {
                req.setAttribute("message","Tai khoan da ton tai !");
                RequestDispatcher view = req.getRequestDispatcher("/register.jsp");
                view.forward(req,resp);
            };
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
