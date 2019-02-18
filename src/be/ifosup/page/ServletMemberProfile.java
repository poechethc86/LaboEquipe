package be.ifosup.page;

import be.ifosup.database.ClubManager;
import be.ifosup.database.MemberManager;
import be.ifosup.database.SportManager;
import be.ifosup.entities.Membre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletMemberProfile", urlPatterns = {"/profileMember"})
public class ServletMemberProfile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Membre membre = MemberManager.Instance().GetMember(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("nom",membre.getNom());
        request.setAttribute("prenom",membre.getPrenom());
        request.setAttribute("id",request.getParameter("id"));
        request.setAttribute("clubs", ClubManager.Instance().DisplayClubs(membre));
        request.setAttribute("clubstosub",ClubManager.Instance().DisplayClubsToSubscribe(membre));
        request.getRequestDispatcher("/vues/membreProfile.jsp").forward(request,response);
    }
}
