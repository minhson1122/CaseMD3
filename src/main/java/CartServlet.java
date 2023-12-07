import com.example.casestudymd3.model.Cart;
import com.example.casestudymd3.model.CartDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private CartDAO cartDAO;
    @Override
    public void init() throws ServletException {
        this.cartDAO = new CartDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null){
            RequestDispatcher view = req.getRequestDispatcher("/cart.jsp");
            view.forward(req,resp);
        }else {
         resp.sendRedirect("/account/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Cart> carts = new ArrayList<Cart>();

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        carts = (ArrayList<Cart>) this.cartDAO.selectCart(username);
        System.out.println(carts);
        RequestDispatcher view = req.getRequestDispatcher("/cart.jsp");
        view.forward(req,resp);
        System.out.println();
    }



}
