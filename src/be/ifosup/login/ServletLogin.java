package be.ifosup.login;

import be.ifosup.database.MemberManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletLogin", urlPatterns = {"/login"})
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // récupération des deux paramètres transmis par le formulaire
        String nom = request.getParameter("nom");
        String pass = request.getParameter("pass");

        // test avec la méthode de validation
        if(MemberManager.Instance().CheckPassword(nom,pass)) {
            request.getSession().setAttribute("nom", nom);

            response.sendRedirect("homepage");
        } else {
            request.setAttribute("errorMessage", "Login invalide");
            request.getRequestDispatcher("/vues/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/vues/login.jsp").forward(request,response);
    }
}
