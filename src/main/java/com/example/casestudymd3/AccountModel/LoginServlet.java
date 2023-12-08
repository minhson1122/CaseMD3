package com.example.casestudymd3.AccountModel;

import com.example.casestudymd3.model.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name="LoginServlet", urlPatterns = "/account/login")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        this.userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/user/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // Lấy giá trị role từ yêu cầu
        String role = req.getParameter("role");

        try {
            if (!this.userDAO.checkUser(username, password)) {
                req.setAttribute("error", "Username and password invalid.");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/user/login.jsp");
                dispatcher.forward(req, resp);
            }else {
                if (!this.userDAO.checkAccountAdmin(username,password,role)) {
                    HttpSession sessions = req.getSession();
                    sessions.setAttribute("username", username);
                    // Chuyển hướng đến trang home.jsp
                    resp.sendRedirect("/home");
                }else {
                    HttpSession sessions = req.getSession();
                    sessions.setAttribute("username", username);
                        resp.sendRedirect("/admin.jsp");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}