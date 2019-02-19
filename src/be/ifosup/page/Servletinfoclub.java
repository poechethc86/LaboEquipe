package be.ifosup.page;

import be.ifosup.database.ClubManager;
import be.ifosup.database.MemberManager;
import be.ifosup.entities.Club;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servletinfoclub",urlPatterns = "/infoclub")
public class Servletinfoclub extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Club club = ClubManager.Instance().GetClub(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("nom",club.getNom());
        request.setAttribute("sport",club.getSport());
        request.setAttribute("id",request.getParameter("id"));
        request.setAttribute("membres",MemberManager.Instance().DisplayMembers(club));

        request.getRequestDispatcher("/vues/clubInfos.jsp").forward(request,response);



    }
}
