package be.ifosup.page;

import be.ifosup.database.SportManager;
import be.ifosup.entities.ClubService;
import be.ifosup.entities.MembreService;
import be.ifosup.entities.Sport;
import be.ifosup.entities.SportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "Servletaddsport" , urlPatterns = {"/add-sport"})
public class Servletaddsport extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String value = request.getParameter("sportName");

        if (value == null) {
            System.out.println("present");

        } else if ("".equals(value)) {
            System.out.println("vide");
        }else{
            System.out.println("aucun des deux ");
        }

        /*request.getParameter("sportName");*/
        request.setCharacterEncoding("UTF-8");
        Sport sport = new Sport(request.getParameter("sportName"));
        SportManager.Instance().AddSport(sport);



           /* JOptionPane.showMessageDialog(null,"Le champ ne peut pas être vide","Inane error", JOptionPane.ERROR_MESSAGE);*/




        response.sendRedirect("homepage");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/vues/homepage.jsp").forward(request,response);
    }
}
