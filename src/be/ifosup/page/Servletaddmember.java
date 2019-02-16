package be.ifosup.page;

import be.ifosup.Utils.MD5Manager;
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

@WebServlet(name = "Servletaddmember", urlPatterns = {"/add-membre"})
public class Servletaddmember extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Membre newmembre = new Membre(request.getParameter("nom"),request.getParameter("prenom"));
        newmembre.setPassword(MD5Manager.Instance().hash(request.getParameter("pass")));
        newmembre.setUser(newmembre.getPrenom().substring(0,1).toLowerCase() + newmembre.getNom().toLowerCase());
        MemberManager.Instance().AddMember(newmembre);
        response.sendRedirect("homepage");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
