import com.example.casestudymd3.model.User;
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
import java.util.List;

@WebServlet(name = "inforUserServlet", urlPatterns = "/infor")
public class inforUserServlet extends HttpServlet {
    private UserDAO userDAO;
    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username != null && !username.isEmpty()) {
            // Gọi phương thức từ UserDAO để lấy thông tin người dùng
            UserDAO userDAO = new UserDAO(); // Đảm bảo rằng bạn đã khởi tạo UserDAO một cách đúng.
            User user = userDAO.getUserByUsername(username);

            if (user != null) {
                // Chuyển thông tin người dùng đến trang userinfo.jsp
                request.setAttribute("user", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/inforuser.jsp");
                dispatcher.forward(request, response);
            } else {
                // Người dùng không tồn tại trong CSDL
                response.sendRedirect("error.jsp"); // Chuyển hướng đến trang lỗi hoặc trang thông báo khác
            }
        } else {
            // Không có giá trị "username" trong session
            response.sendRedirect("login.jsp"); // Chuyển hướng đến trang đăng nhập
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username != null && !username.isEmpty()) {
            // Lấy thông tin mới từ form
            String name = request.getParameter("name");
//            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String password = request.getParameter("password");
            // Thêm các thông tin khác cần sửa

            // Gọi phương thức từ UserDAO để sửa thông tin người dùng
            UserDAO userDAO = new UserDAO();
            boolean success = false;
            try {
                success = userDAO.updateUserByName(name,address,username,password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            userDAO.closeConnection();

            if (success) {
                // Làm mới thông tin người dùng sau khi cập nhật thành công
                User updatedUser = userDAO.getUserByUsername(username);
                request.setAttribute("user", updatedUser);
                request.setAttribute("message","Da sua thanh cong !");

                // Chuyển hướng về trang userinfo.jsp sau khi sửa thành công
                RequestDispatcher dispatcher = request.getRequestDispatcher("/inforuser.jsp");
                dispatcher.forward(request, response);
            } else {
                // Chuyển hướng đến trang lỗi hoặc trang thông báo khác
                response.sendRedirect("error.jsp");
            }
        } else {
            // Không có giá trị "username" trong session
            response.sendRedirect("login.jsp"); // Chuyển hướng đến trang đăng nhập
        }
    }
    }

//    private void updateUser(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException,ServletException {
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String address = request.getParameter("address");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        User userNew = new User(name,email,address,username,password);
//        userDAO.updateUserByName(userNew);
//        request.setAttribute("message","Da sua thanh cong !");
//        RequestDispatcher view = request.getRequestDispatcher("/inforuser.jsp");
//        view.forward(request,response);
//    }

