package be.ifosup.page;

import be.ifosup.entities.ClubService;
import be.ifosup.entities.MembreService;
import be.ifosup.entities.SportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletHomepage", urlPatterns = {"/homepage"})
public class ServletHomepage extends HttpServlet {
    private MembreService membreService = new MembreService();
    private ClubService clubService = new ClubService();
    private SportService sportService = new SportService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("membres",membreService.recupereMembre());
        request.setAttribute("clubs",clubService.recupereClub());
        request.setAttribute("sports",sportService.recupereSport());
        request.getRequestDispatcher("/vues/homepage.jsp").forward(request,response);
    }
}
