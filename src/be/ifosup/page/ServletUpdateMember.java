package be.ifosup.page;

import be.ifosup.database.MemberManager;
import be.ifosup.entities.Membre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "ServletUpdateMember", urlPatterns = {"/update-member"})
public class ServletUpdateMember extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        if(!request.getParameter("firstname").equals("") && !request.getParameter("lastname").equals("")) {
            Membre membre = new Membre(Integer.parseInt(request.getParameter("id")));
            membre.setPrenom(request.getParameter("firstname"));
            membre.setNom(request.getParameter("lastname"));
            MemberManager.Instance().UpdateMember(membre);
        }else{
            JOptionPane pane = new JOptionPane("Veuillez completer le champ", JOptionPane.ERROR_MESSAGE);
            JDialog dialog = pane.createDialog(null,"erreur");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            dialog.dispose();
        }
        response.sendRedirect("profileMember?id="+request.getParameter("id"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
