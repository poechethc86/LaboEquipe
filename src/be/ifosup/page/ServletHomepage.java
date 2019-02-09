package be.ifosup.page;

import be.ifosup.entities.MembreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletHomepage", urlPatterns = {"/homepage"})
public class ServletHomepage extends HttpServlet {
    private MembreService membreService = new MembreService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("membres",membreService.recupereMembre());
        System.out.println(request.getAttribute("membres"));
        request.getRequestDispatcher("/vues/homepage.jsp").forward(request,response);
    }
}
