package be.ifosup.page;

import be.ifosup.entities.SportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletSport", urlPatterns = {"/sport"})
public class ServletSport extends HttpServlet {
    //création d'une instance de SportService
    private SportService sportService = new SportService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Récupération des sports
        request.setAttribute("sports", sportService.recupereSport());


        // affichage de la vue :
        request.getRequestDispatcher("vues/homepage.jsp").forward(request, response);
    }
}
