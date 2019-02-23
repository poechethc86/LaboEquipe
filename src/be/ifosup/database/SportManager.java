package be.ifosup.database;

import be.ifosup.entities.Club;
import be.ifosup.entities.Membre;
import be.ifosup.entities.Sport;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SportManager extends DBManager {
    private SportManager () {}

    private static SportManager instance = null;

    public static SportManager Instance () {
        if (instance == null) {
            instance = new SportManager();
        }
        return instance;
    }

    public boolean AddSport (Sport sport) {
        boolean noError = true;
        try {
            ConnectDB();
            System.out.println(sport.getNomSport());
            preparedStatement = connection.prepareStatement("INSERT INTO `t_sports`(`Nom_Sport`) VALUES (?);");




            preparedStatement.setString(1,sport.getNomSport());
             preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            noError = false;
        } finally {
            CloseDB();
        }
        return noError;
    }

    public boolean RemoveSport(Sport sport){  // /!\ controle displaysport puis displayclub before

        boolean noError = true;



            try {
                ConnectDB();


                preparedStatement=connection.prepareStatement("SELECT t_clubs.FK_Sport FROM t_clubs WHERE t_clubs.FK_Sport=?");
                preparedStatement.setInt(1, sport.getPk_sport());
                result = preparedStatement.executeQuery();

                if(result.next()) {
                    JOptionPane pane = new JOptionPane("le sport est affilié a un club impossible de le supprimer", JOptionPane.ERROR_MESSAGE);
                    JDialog dialog = pane.createDialog(null,"error");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                    dialog.dispose();

                }else{

                preparedStatement = connection.prepareStatement("Delete FROM `t_sports` WHERE `PK_Sport`= ? ");
                preparedStatement.setInt(1, sport.getPk_sport());
                preparedStatement.executeUpdate();}


            } catch (SQLException e) {
                e.printStackTrace();
                noError = false;
            } finally {
                CloseDB();
            }






        return noError;
    }

    public boolean UpdateSport(Sport sport){
        boolean noError = true;
        try {
            ConnectDB();




            preparedStatement = connection.prepareStatement("UPDATE t_Sports SET Nom_Sport =?  WHERE PK_Sport = ? ");

            preparedStatement.setString(1, sport.getNomSport());
            preparedStatement.setInt(2,sport.getPk_sport());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            noError = false;
        } finally {
            CloseDB();
        }
        return noError;
    }


    public List<Sport> DisplaySports(Membre member){

        ArrayList<Sport> listsport = new ArrayList<Sport>();
        try {
            ConnectDB();
            preparedStatement = connection.prepareStatement("SELECT t_sports.Nom_Sport FROM t_membres INNER JOIN ((t_sports INNER JOIN t_clubs ON t_sports.PK_Sport = t_clubs.FK_Sport) INNER JOIN ti_membres_clubs ON t_clubs.PK_Club = ti_membres_clubs.FK_Clubs) ON t_membres.PK_Membres = ti_membres_clubs.FK_Membres WHERE (((t_membres.PK_Membres)=?));");
            preparedStatement.setInt(1,member.getPk_membre());
            result = preparedStatement.executeQuery();


            while (result.next()){
                Sport sport = new Sport(result.getString(1));
                listsport.add( sport);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseDB();
        }

        return listsport;





    }

    public List<Sport> DisplaySports() {

        ArrayList<Sport> listsport = new ArrayList<Sport>();
        try {
            ConnectDB();
            preparedStatement = connection.prepareStatement("SELECT t_sports.Nom_Sport, t_sports.PK_Sport FROM t_sports;");
            result = preparedStatement.executeQuery();

            while (result.next()){
                Sport sport = new Sport(result.getString(1),result.getInt(2));
                listsport.add(sport);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseDB();
        }

        return listsport;




    }

    public Sport GetSport (int pk_sport) {
        Sport sport = new Sport(pk_sport);
        try {
            ConnectDB();
            preparedStatement = connection.prepareStatement("SELECT t_sports.PK_Sport, t_sports.Nom_Sport FROM t_sports WHERE t_sports.PK_Sport=?;");
            preparedStatement.setInt(1,pk_sport);

            result = preparedStatement.executeQuery();
            if (result.next()) {

                sport.setNomSport(result.getString(2));
                sport.setPk_sport(result.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseDB();
        }
        return sport;
    }




}
