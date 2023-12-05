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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminServlet",urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {

    private UserDAO userDAO;
    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    showFormAdd(req,resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                listUsers(req, resp);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertUser(req,resp);
                break;
            default:
                break;
        }
    }

    private void listUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> listUsers = this.userDAO.selectAllUser();
        req.setAttribute("listUsers", listUsers);
        RequestDispatcher view = req.getRequestDispatcher("/admin/list.jsp");
        view.forward(req, resp);
        System.out.println("Return success!");
    }

    private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User userNew = new User(name,email, address, username, password);

        userDAO.insertUser(userNew);
        req.setAttribute("message","Da them thanh cong !");
        RequestDispatcher view = req.getRequestDispatcher("/admin/add.jsp");
        view.forward(req,resp);
    }

    private void showFormAdd(HttpServletRequest req, HttpServletResponse resp) throws Exception,ServletException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/add.jsp");
        dispatcher.forward(req, resp);
    }
}
