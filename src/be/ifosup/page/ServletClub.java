package be.ifosup.page;

import be.ifosup.entities.ClubService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ServletClub", urlPatterns = {"/club"})
public class ServletClub extends HttpServlet {
    // Création d'un instance de Club
    private ClubService clubService = new ClubService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupération des clubs
        request.setAttribute("clubs", clubService.recupereClub());

        // affichage de la vue todoList
        request.getRequestDispatcher("vues/homepage.jsp").forward(request, response);
    }
}
