package jp.co.aivick.firstweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/firstservlet"})
public class FirstServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        out.write("<html>");
        out.write("<head>");
        out.write("<title>First Web App</title>");
        out.write("</head>");
        out.write("<body>");
        out.write("Hello, Servlet");
        out.write("</body>");
        out.write("</html>");
    }
}
