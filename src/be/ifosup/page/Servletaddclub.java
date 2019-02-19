package be.ifosup.page;

import be.ifosup.database.ClubManager;
import be.ifosup.database.SportManager;
import be.ifosup.entities.Club;
import be.ifosup.entities.Sport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servletaddclub" , urlPatterns = {"/add-club"})
public class Servletaddclub extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("coucou");
        request.setCharacterEncoding("UTF-8");
        Club club = new Club(request.getParameter("clubName"));
        club.setSport(request.getParameter("sportName"));
        ClubManager.Instance().AddClub(club);
        response.sendRedirect("homepage");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
