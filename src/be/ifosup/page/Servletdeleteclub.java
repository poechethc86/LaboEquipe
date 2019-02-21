package be.ifosup.page;

import be.ifosup.database.ClubManager;
import be.ifosup.entities.Club;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servletdeleteclub",urlPatterns = "/delete-club")
public class Servletdeleteclub extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Club club = new Club(Integer.parseInt(request.getParameter("clubId")));
        ClubManager.Instance().RemoveClub(club);

        response.sendRedirect("infosport?id="+Integer.parseInt(request.getParameter("sportId")));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
