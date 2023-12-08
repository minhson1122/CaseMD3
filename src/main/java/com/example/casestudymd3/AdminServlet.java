package com.example.casestudymd3;

import com.example.casestudymd3.model.User;
import com.example.casestudymd3.model.UserDAO;

import javax.jws.soap.SOAPBinding;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminServlet",urlPatterns = "/admin/listuserdata")
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
            case "delete":
                try {
                    deleteUser(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "update":
                try {
                    showEditUser(req,resp);
                } catch (SQLException e) {
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
            case "update":
                try {
                    updateUser(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteUser(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
    }

    private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        User userNew = new User(name,email, address, username, password,role);


        try {
            if (!userDAO.checkRegister(email,username)){
                userDAO.insertUser(userNew);
                req.setAttribute("message","Da them thanh cong !");
                RequestDispatcher view = req.getRequestDispatcher("/admin/add.jsp");
                view.forward(req,resp);
            }else {
                req.setAttribute("message","Tai khoan da ton tai !");
                RequestDispatcher view = req.getRequestDispatcher("/admin/add.jsp");
                view.forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showFormAdd(HttpServletRequest req, HttpServletResponse resp) throws Exception,ServletException {
//        resp.sendRedirect("/listuserdata?action=create");

        RequestDispatcher view = req.getRequestDispatcher("/admin/add.jsp");
        view.forward(req,resp);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,SQLException,IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
        List<User> listUsers = userDAO.selectAllUser();
        request.setAttribute("listUsers",listUsers);
        RequestDispatcher view = request.getRequestDispatcher("/admin/list.jsp");
        view.forward(request,response);
//        response.sendRedirect("/admin/listuserdata");
    }

    private void updateUser(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException,ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        User userNew = new User(id,name,email,address,username,password,role);
        userDAO.updateUser(userNew);
        request.setAttribute("message","Da sua thanh cong !");
        RequestDispatcher view = request.getRequestDispatcher("/admin/edit.jsp");
        view.forward(request,response);
    }

    private void showEditUser(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException,IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDAO.selectUser(id);
        RequestDispatcher view = request.getRequestDispatcher("/admin/edit.jsp");
        request.setAttribute("user",existingUser);
        view.forward(request,response);
    }
}
