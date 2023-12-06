package com.example.casestudymd3.AccountModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name="LoginServlet", urlPatterns = "/account/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // Lấy giá trị role từ yêu cầu
        String role = req.getParameter("role");

        if (username.equals("shit") || password.equals("1111")) {
            req.setAttribute("error", "Username and password invalid.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
            dispatcher.forward(req, resp);
        } else {

            // Xử lý logic tương ứng với vai trò và tạo phản hồi
            String result;
            if ("user".equals(role)) {
//                resp.sendRedirect("/account");
                HttpSession sessions = req.getSession();
                sessions.setAttribute("username", username);

                // Chuyển hướng đến trang home.jsp
                resp.sendRedirect("/home.jsp");
            } else if ("admin".equals(role) && username.equals("ADMIN") && password.equals("ADMINgameSHOP")) {
                resp.sendRedirect("/admin");
            }
        }
    }
}