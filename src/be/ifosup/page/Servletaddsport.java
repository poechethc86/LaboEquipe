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

        System.out.println("test");
        System.out.println(request.getParameter("sportName"));
        Sport sport = new Sport(request.getParameter("sportName"));
        SportManager.Instance().AddSport(sport);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
