package be.ifosup.page;

import be.ifosup.database.ClubManager;
import be.ifosup.entities.Club;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "ServletUpdateClub",urlPatterns = "/update-club")
public class ServletUpdateClub extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        if(!request.getParameter("nom").equals("")) {
            Club club = new Club(Integer.parseInt(request.getParameter("id")));
            club.setNom(request.getParameter("nom"));
            club.setPkSport(Integer.parseInt(request.getParameter("sportId")));
            ClubManager.Instance().UpdateClub(club);
        }else{
            JOptionPane pane = new JOptionPane("Veuillez completer le champ", JOptionPane.ERROR_MESSAGE);
            JDialog dialog = pane.createDialog(null,"erreur");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            dialog.dispose();
        }

        response.sendRedirect("infoclub?id=" + request.getParameter("id"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
