package be.ifosup.page;

import be.ifosup.database.MemberManager;
import be.ifosup.database.SportManager;
import be.ifosup.entities.Membre;
import be.ifosup.entities.Sport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Member;

@WebServlet(name = "Servletaddmember")
public class Servletaddmember extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Membre newmembre = new Membre(request.getParameter("nom"),request.getParameter("prenom"));
        MemberManager.Instance().AddMember(newmembre);
        response.sendRedirect("homepage");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
