package be.ifosup.page;

import be.ifosup.database.ClubManager;
import be.ifosup.database.SportManager;
import be.ifosup.entities.Sport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servletinfosport" ,urlPatterns = "/infosport")
public class Servletinfosport extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Sport sport = SportManager.Instance().GetSport(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("nom",sport.getNomSport());
        request.setAttribute("id",request.getParameter("id"));
        request.setAttribute("membres", ClubManager.Instance().DisplayClubsandcount(sport));


        request.getRequestDispatcher("/vues/sportInfos.jsp").forward(request,response);

    }
}
