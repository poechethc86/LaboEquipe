package be.ifosup.page;

import be.ifosup.database.SportManager;
import be.ifosup.entities.Sport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servletdelsport" , urlPatterns = "/delsport")
public class Servletdelsport extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Sport sport = new Sport(Integer.parseInt(request.getParameter("sportId")));
        SportManager.Instance().RemoveSport(sport);

        response.sendRedirect("/homepage");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
