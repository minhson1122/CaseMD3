import com.example.casestudymd3.model.Game;
import com.example.casestudymd3.model.GameDAO;
import com.example.casestudymd3.model.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="GameInforServlet", urlPatterns = "/gameinfor")
public class GameInforServlet extends HttpServlet {

    private GameDAO gameDAO;
    @Override
    public void init() throws ServletException {
        gameDAO = new GameDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Game game = this.gameDAO.selectGame(id);
        req.setAttribute("game", game);
        System.out.println(game);
        RequestDispatcher view = req.getRequestDispatcher("/gameinfor.jsp");
        view.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
