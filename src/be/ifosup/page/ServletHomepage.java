package be.ifosup.page;

import be.ifosup.database.ClubManager;
import be.ifosup.database.MemberManager;
import be.ifosup.database.SportManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletHomepage", urlPatterns = {"/homepage"})
public class ServletHomepage extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("membres", MemberManager.Instance().DisplayMembers());
        request.setAttribute("clubs",ClubManager.Instance().DisplayClubs());
        request.setAttribute("sports",SportManager.Instance().DisplaySports());
        request.getRequestDispatcher("/vues/homepage.jsp").forward(request,response);

    }
}
