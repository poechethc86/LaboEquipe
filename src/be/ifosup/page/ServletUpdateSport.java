package be.ifosup.page;

import be.ifosup.database.SportManager;
import be.ifosup.entities.Sport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "ServletUpdateSport",urlPatterns = "/update-sport")
public class ServletUpdateSport extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        if(!request.getParameter("nom").equals("")) {
            Sport sport = new Sport(Integer.parseInt(request.getParameter("id")));
            sport.setNomSport(request.getParameter("nom"));

            SportManager.Instance().UpdateSport(sport);
        }else{
            JOptionPane pane = new JOptionPane("Veuillez completer le champ", JOptionPane.ERROR_MESSAGE);
            JDialog dialog = pane.createDialog(null,"erreur");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            dialog.dispose();

        }
        response.sendRedirect("infosport?id=" + request.getParameter("id"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
