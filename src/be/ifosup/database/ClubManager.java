package be.ifosup.database;

import be.ifosup.entities.Club;
import be.ifosup.entities.Membre;
import be.ifosup.entities.Sport;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClubManager extends DBManager {

    private ClubManager() {
    }

    private static ClubManager instance = null;

    public static ClubManager Instance() {
        if (instance == null) {
            instance = new ClubManager();
        }
        return instance;
    }

    public boolean AddClub(Club club) {

        boolean noError = true;
        try {
            ConnectDB();


            preparedStatement = connection.prepareStatement("SELECT t_sports.PK_Sport FROM t_sports WHERE t_sports.Nom_Sport=?");
            preparedStatement.setString(1, club.getSport());
            result = preparedStatement.executeQuery();
            result.next();
            int pksport = result.getInt(1);

            preparedStatement = connection.prepareStatement("INSERT INTO t_clubs(Nom_Club,FK_Sport) VALUES (?, ?)");
            preparedStatement.setString(1, club.getNom());
            preparedStatement.setInt(2, pksport);


            result = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            noError = false;
        } finally {
            CloseDB();
        }
        return noError;
    }


    public boolean RemoveClub(Club club) {

        boolean noError = true;
        try {
            ConnectDB();


            preparedStatement = connection.prepareStatement("DELETE FROM ti_membres_clubs WHERE ti_membres_clubs.FK_Clubs=?;");
            preparedStatement.setInt(1, club.getPk_club());
            result = preparedStatement.executeQuery();


            preparedStatement = connection.prepareStatement("DELETE FROM t_clubs WHERE t_clubs.PK_Club=?");
            preparedStatement.setInt(1, club.getPk_club());
            result = preparedStatement.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
            noError = false;
        } finally {
            CloseDB();
        }
        return noError;
    }

    public boolean UpdateClub(Club club) {

        boolean noError = true;
        try {
            ConnectDB();

            preparedStatement = connection.prepareStatement("SELECT t_sports.PK_Sport FROM t_sports WHERE t_sports.Nom_Sport=?");
            preparedStatement.setString(1, club.getSport());
            result = preparedStatement.executeQuery();
            result.next();
            int pksport = result.getInt(1);


            preparedStatement = connection.prepareStatement("UPDATE t_clubs SET Nom_club =? FK_Sport = ? WHERE PK_Club = ? ");

            preparedStatement.setString(1, club.getNom());
            preparedStatement.setInt(2,pksport);
            result = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            noError = false;
        } finally {
            CloseDB();
        }
        return noError;


    }


    public List<Club> DisplayClubs() {

        ArrayList<Club> listclub = new ArrayList<Club>();
        try {
            ConnectDB();
            preparedStatement = connection.prepareStatement("SELECT t_clubs.Nom_Club, t_sports.Nom_Sport, Count(ti_membres_clubs.FK_Membres) AS CompteDeFK_Membres, t_clubs.PK_Club FROM (t_sports INNER JOIN t_clubs ON t_sports.PK_Sport = t_clubs.FK_Sport) LEFT JOIN ti_membres_clubs ON t_clubs.PK_Club = ti_membres_clubs.FK_ClubsGROUP BY t_clubs.Nom_Club, t_sports.Nom_Sport, t_clubs.PK_Club;");
            result = preparedStatement.executeQuery();

            while (result.next()){
                Club club = new Club(result.getString(1),result.getString(2),result.getInt(3));

                listclub.add(club);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseDB();
        }

        return listclub;




    }

    public List<Club> DisplayClubs(Membre member) {

        ArrayList<Club> listclub = new ArrayList<Club>();
        try {
            ConnectDB();
            preparedStatement = connection.prepareStatement("SELECT t_clubs.Nom_Club FROM t_sports INNER JOIN (t_membres INNER JOIN (t_clubs INNER JOIN ti_membres_clubs ON t_clubs.PK_Club = ti_membres_clubs.FK_Clubs) ON t_membres.PK_Membres = ti_membres_clubs.FK_Membres) ON t_sports.PK_Sport = t_clubs.FK_Sport WHERE (((t_membres.PK_Membres)=?));");
            preparedStatement.setInt(1,member.getPk_membre());
            result = preparedStatement.executeQuery();


            while (result.next()){
                Club club = new Club(result.getString(1));
                listclub.add(club);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseDB();
        }

        return listclub;


    }

    public List<Club> DisplayClubs(Sport sport) {
        ArrayList<Club> listclub = new ArrayList<Club>();
        try {
            ConnectDB();
            preparedStatement = connection.prepareStatement("SELECT t_clubs.Nom_Club FROM t_sports INNER JOIN t_clubs ON t_sports.PK_Sport = t_clubs.FK_Sport  WHERE t_sports.PK_Sport=?");
            preparedStatement.setInt(1,sport.getPk_sport());
            result = preparedStatement.executeQuery();

            while (result.next()){
                Club club = new Club(result.getString(1));
                listclub.add(club);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseDB();
        }

        return listclub;

    }




}



