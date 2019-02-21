package be.ifosup.page;

import be.ifosup.database.ClubManager;
import be.ifosup.entities.Club;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletUpdateClub",urlPatterns = "/update-club")
public class ServletUpdateClub extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Club club = new Club(Integer.parseInt(request.getParameter("id")));
        club.setNom(request.getParameter("nom"));
        club.setPkSport(Integer.parseInt(request.getParameter("sportId")));
        ClubManager.Instance().UpdateClub(club);

        response.sendRedirect("infoclub?id=" + club.getPk_club());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
