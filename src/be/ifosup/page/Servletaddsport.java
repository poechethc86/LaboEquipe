package be.ifosup.page;

import be.ifosup.database.SportManager;
import be.ifosup.entities.Sport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servletaddsport" , urlPatterns = {"/add-sport"})
public class Servletaddsport extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        if(!request.getParameter("sportName").equals("")) {

            request.setCharacterEncoding("UTF-8");
            Sport sport = new Sport(request.getParameter("sportName"));
            SportManager.Instance().AddSport(sport);
        }

        response.sendRedirect("homepage");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/vues/homepage.jsp").forward(request,response);
    }
}
