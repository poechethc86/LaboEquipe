package be.ifosup.page;

import be.ifosup.database.MemberManager;
import be.ifosup.entities.Club;
import be.ifosup.entities.Membre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servletunsubscribemember" , urlPatterns = "/unsubscribe-membre")
public class Servletunsubscribemember extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            request.setCharacterEncoding("UTF-8");
            Membre membre = new Membre(Integer.parseInt(request.getParameter("memberId")));
            MemberManager.Instance().UnsubscribeClub(membre,new Club(Integer.parseInt(request.getParameter("clubId"))));
            response.sendRedirect("infoclub?id="+Integer.parseInt(request.getParameter("clubId")));
        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
