package be.ifosup.database;

import be.ifosup.Utils.MD5Manager;
import be.ifosup.entities.Membre;

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

    public boolean AddMember(Membre member){
        boolean noError = true;
        try {
            ConnectDB();
            preparedStatement = connection.prepareStatement("INSERT INTO `t_membres`( `Nom_Membres`,`Prenom_Membres`, `Pass_Membres`,`User_Membres`) VALUES (?,? ,?,?)");
            preparedStatement.setString(1,member.getNom());
            preparedStatement.setString(2,member.getPrenom());
            preparedStatement.setString(3,member.getPassword());
            preparedStatement.setString(4,member.getUser());

            result = preparedStatement.executeQuery();

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
            result = preparedStatement.executeQuery();

            preparedStatement = connection.prepareStatement("Delete FROM `t_membres` WHERE `PK_Membres`= ?");
            preparedStatement.setInt(1,member.getPk_membre());
            result = preparedStatement.executeQuery();


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
            preparedStatement = connection.prepareStatement("UPDATE t_membres SET Nom_Membres =? Prenom_Membres = ? WHERE PK_Membres = ?");
            preparedStatement.setString(1,member.getNom());
            preparedStatement.setString(2,member.getPrenom());
            preparedStatement.setInt(3,member.getPk_membre());
            result = preparedStatement.executeQuery();

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
            preparedStatement = connection.prepareStatement("SELECT t_membres.Nom_Membres, t_membres.Prenom_Membres , t_membres.PK_Membres FROM t_membres;");
            result = preparedStatement.executeQuery();

            while (result.next()){
                Membre membre = new Membre(result.getString(1),result.getString(2),result.getInt(3));

                            }

        } catch (SQLException e) {
            e.printStackTrace();
                  } finally {
            CloseDB();
        }

        return listemembre;
    }




}
