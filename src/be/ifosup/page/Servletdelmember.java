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
import java.lang.reflect.Member;

@WebServlet(name = "Servletdelmember",urlPatterns = "/delete-member")
public class Servletdelmember extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        Membre membre = MemberManager.Instance().GetMember(Integer.parseInt(request.getParameter("memberId")));
        if (!request.getSession().getAttribute("user").equals(request.getParameter("usernameToDelete"))) {
            MemberManager.Instance().RemoveMember(membre);
        }else{
            JOptionPane pane = new JOptionPane("autosuppression interdite", JOptionPane.ERROR_MESSAGE);
            JDialog dialog = pane.createDialog(null,"erreur");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            dialog.dispose();
        }

        response.sendRedirect("homepage");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
