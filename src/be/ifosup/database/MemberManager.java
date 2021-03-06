package be.ifosup.database;

import be.ifosup.Utils.MD5Manager;
import be.ifosup.entities.Club;
import be.ifosup.entities.Membre;
import be.ifosup.entities.Sport;

import java.sql.SQLException;
import java.util.*;

public class MemberManager extends DBManager {

    private MemberManager() {}

    private static MemberManager instance = null;

    public static MemberManager Instance () {
        if (instance == null) {
            instance = new MemberManager();
        }
        return instance;
    }

    public boolean CheckPassword (String Username, String Password) {
        boolean passwordOK = false;
        try {
            String MD5Password = MD5Manager.Instance().hash(Password);
            ConnectDB();
            preparedStatement = connection.prepareStatement("SELECT * FROM `t_membres` WHERE `User_Membres` = ? AND `Pass_Membres` = ?");
            preparedStatement.setString(1,Username);
            preparedStatement.setString(2,MD5Password);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                passwordOK = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseDB();
        }
        return passwordOK;
    }

    public Membre GetMember (int pk_membre) {
        Membre membre = new Membre(pk_membre);
        try {
            ConnectDB();
            preparedStatement = connection.prepareStatement("SELECT t_membres.Nom_Membres, t_membres.Prenom_Membres, t_membres.User_Membres FROM t_membres WHERE `PK_Membres` = ?");
            preparedStatement.setInt(1,pk_membre);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                membre.setNom(result.getString(1));
                membre.setPrenom(result.getString(2));
                membre.setUser(result.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseDB();
        }
        return membre;
    }

    public boolean AddMember(Membre member){
        boolean noError = true;
        try {
            ConnectDB();
            preparedStatement = connection.prepareStatement("INSERT INTO `t_membres`( `Nom_Membres`,`Prenom_Membres`, `Pass_Membres`,`User_Membres`) VALUES (?,? ,?,?)");
            preparedStatement.setString(1,member.getNom());
            preparedStatement.setString(2,member.getPrenom());
            preparedStatement.setString(3,member.getPassword());
            preparedStatement.setString(4,member.getUser());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            noError = false;
        } finally {
            CloseDB();
        }
        return noError;
    }


    public boolean RemoveMember(Membre member){
        boolean noError = true;
        try {
            ConnectDB();

            preparedStatement = connection.prepareStatement("DELETE FROM ti_membres_clubs WHERE ti_membres_clubs.FK_Membres=?");
            preparedStatement.setInt(1,member.getPk_membre());
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("Delete FROM `t_membres` WHERE `PK_Membres`= ?");
            preparedStatement.setInt(1,member.getPk_membre());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            noError = false;
        } finally {
            CloseDB();
        }
        return noError;
    }

    public boolean UpdateMember(Membre member){

        boolean noError = true;
        try {
            ConnectDB();
            preparedStatement = connection.prepareStatement("UPDATE t_membres SET `Nom_Membres` = ?, `Prenom_Membres` = ? WHERE `t_membres`.`PK_Membres` = ?");
            preparedStatement.setString(1,member.getNom());
            preparedStatement.setString(2,member.getPrenom());
            preparedStatement.setInt(3,member.getPk_membre());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            noError = false;
        } finally {
            CloseDB();
        }
        return noError;


    }

    public List<Membre> DisplayMembers(){
        ArrayList<Membre> listemembre = new ArrayList<Membre>();
        try {
            ConnectDB();
            preparedStatement = connection.prepareStatement("SELECT t_membres.Nom_Membres, t_membres.Prenom_Membres , t_membres.PK_Membres, t_membres.User_Membres FROM t_membres ORDER BY t_membres.Nom_Membres");
            result = preparedStatement.executeQuery();

            while (result.next()){
                Membre membre = new Membre(result.getString(1),result.getString(2));
                membre.setPk_membre(result.getInt(3));
                membre.setUser(result.getString(4));
                listemembre.add(membre);
                                 }

        } catch (SQLException e) {
            e.printStackTrace();
                  } finally {
            CloseDB();
        }

        return listemembre;
    }

    public List<Membre> DisplayMembers(Club club){
        ArrayList<Membre> listemembre = new ArrayList<Membre>();

        try {
        ConnectDB();
        preparedStatement = connection.prepareStatement("SELECT t_membres.Nom_Membres, t_membres.Prenom_Membres, t_membres.PK_Membres FROM t_membres INNER JOIN (t_clubs INNER JOIN ti_membres_clubs ON t_clubs.PK_Club = ti_membres_clubs.FK_Clubs) ON t_membres.PK_Membres = ti_membres_clubs.FK_Membres WHERE t_clubs.PK_Club=? ORDER BY t_membres.Nom_Membres");

        preparedStatement.setInt(1,club.getPk_club());
        result = preparedStatement.executeQuery();

        while (result.next()){
            Membre membre = new Membre(result.getString(1),result.getString(2));
            membre.setPk_membre(result.getInt(3));
            listemembre.add(membre);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        CloseDB();
    }

        return listemembre;


    }

    public List<Membre> DisplayMembersToSubscribe(Club club){
        ArrayList<Membre> listemembre = new ArrayList<Membre>();

        try {
            ConnectDB();
            preparedStatement = connection.prepareStatement("SELECT t_membres.Nom_Membres, t_membres.Prenom_Membres, t_membres.PK_Membres FROM t_membres LEFT JOIN (t_clubs INNER JOIN ti_membres_clubs ON t_clubs.PK_Club = ti_membres_clubs.FK_Clubs) ON t_membres.PK_Membres = ti_membres_clubs.FK_Membres WHERE t_membres.PK_Membres NOT IN (SELECT ti_membres_clubs.FK_Membres FROM ti_membres_clubs WHERE ti_membres_clubs.FK_Clubs = ?) ORDER BY t_membres.Nom_Membres");

            preparedStatement.setInt(1,club.getPk_club());
            result = preparedStatement.executeQuery();

            while (result.next()){
                Membre membre = new Membre(result.getString(1),result.getString(2));
                membre.setPk_membre(result.getInt(3));
                listemembre.add(membre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseDB();
        }

        return listemembre;


    }

    public List<Membre> DisplayMembers (Sport sport){

        ArrayList<Membre> listemembre = new ArrayList<Membre>();

        try {
            ConnectDB();
            preparedStatement = connection.prepareStatement("SELECT t_membres.Nom_Membres, t_membres.Prenom_Membres FROM t_membres INNER JOIN ((t_sports INNER JOIN t_clubs ON t_sports.PK_Sport = t_clubs.FK_Sport)                    INNER JOIN ti_membres_clubs ON t_clubs.PK_Club = ti_membres_clubs.FK_Clubs) ON t_membres.PK_Membres = ti_membres_clubs.FK_Membres HERE (((t_sports.PK_Sport)=?))");

            preparedStatement.setInt(1,sport.getPk_sport());
            result = preparedStatement.executeQuery();

            while (result.next()){
                Membre membre = new Membre(result.getString(1),result.getString(2));
                membre.setPk_membre(result.getInt(3));
                listemembre.add(membre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseDB();
        }

        return listemembre;


    }

    public boolean userexist(String nom,String prenom) {
        boolean noError = true;
        try {
            ConnectDB();

            preparedStatement = connection.prepareStatement("SELECT t_membres.Nom_Membres, t_membres.Prenom_Membres FROM t_membres WHERE (((t_membres.Nom_Membres)=?) AND ((t_membres.Prenom_Membres)=?));");
            preparedStatement.setString(1,nom);
            preparedStatement.setString(2, prenom);
            result = preparedStatement.executeQuery();
            if(!result.next()){
                noError = false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            noError = false;
        } finally {
            CloseDB();
        }

        return noError;
    }
    public boolean SubscribeClub (Membre member, Club club){

        boolean noError = true;
        try {
            ConnectDB();

            preparedStatement = connection.prepareStatement("INSERT INTO ti_membres_clubs ( `FK_Clubs`,`FK_Membres`) VALUES (?, ?)");
            preparedStatement.setInt(1,club.getPk_club());
            preparedStatement.setInt(2,member.getPk_membre());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            noError = false;
        } finally {
            CloseDB();
        }
        return noError;
    }

    public boolean UnsubscribeClub (Membre member, Club club){
        boolean noError = true;
        try {
            ConnectDB();

            preparedStatement = connection.prepareStatement("Delete FROM `ti_membres_clubs` WHERE `FK_Clubs`= ? AND `FK_Membres`= ?");
            preparedStatement.setInt(1,club.getPk_club());
            preparedStatement.setInt(2,member.getPk_membre());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            noError = false;
        } finally {
            CloseDB();
        }
        return noError;
    }

    public Membre GetUser (int pk_membre) {
        Membre membre = new Membre(pk_membre);
        try {
            ConnectDB();
            preparedStatement = connection.prepareStatement("SELECT t_membres.User_Membres, t_membres.Prenom_Membres FROM t_membres WHERE `PK_Membres` = ?");
            preparedStatement.setInt(1, pk_membre);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                membre.setUser(result.getString(1));
                membre.setPrenom(result.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseDB();
        }
        return membre;


    }
}









