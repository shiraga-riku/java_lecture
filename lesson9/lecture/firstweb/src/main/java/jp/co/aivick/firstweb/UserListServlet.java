package jp.co.aivick.firstweb;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jp.co.aivick.model.User;

@WebServlet(urlPatterns = {"/users"})
public class UserListServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        List<User> users = List.of(
            new User("taro", 25),
            new User("hanako", 30),
            new User("ichiro", 40),
            new User("jon", 28),
            new User("takeru", 35)
        );

        req.setAttribute("users", users);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
        requestDispatcher.forward(req, resp);
    }
}
