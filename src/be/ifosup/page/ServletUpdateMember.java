package be.ifosup.page;

import be.ifosup.database.MemberManager;
import be.ifosup.entities.Membre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletUpdateMember", urlPatterns = {"/update-member"})
public class ServletUpdateMember extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Membre membre = new Membre(Integer.parseInt(request.getParameter("id")));
        membre.setPrenom(request.getParameter("firstname"));
        membre.setNom(request.getParameter("lastname"));
        MemberManager.Instance().UpdateMember(membre);
        response.sendRedirect("profileMember?id="+membre.getPk_membre());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
