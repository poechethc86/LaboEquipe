package be.ifosup.database;

import be.ifosup.Utils.MD5Manager;
import be.ifosup.entities.Membre;

import java.sql.SQLException;

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
            preparedStatement = connection.prepareStatement("SELECT t_membres.PK_Membres FROM t_membres WHERE (((t_membres.Prenom_Membres)=?) AND ((t_membres.Nom_Membres)=?))");
            preparedStatement.setString(1,member.getPrenom());
            preparedStatement.setString(2,member.getNom());


            result = preparedStatement.executeQuery();
            result.next();
            int pk = result.getInt(1);

            preparedStatement = connection.prepareStatement("DELETE FROM ti_membres_clubs WHERE ti_membres_clubs.FK_Membres=?");
            preparedStatement.setInt(1,pk);
            result = preparedStatement.executeQuery();

            preparedStatement = connection.prepareStatement("Delete FROM `t_membres` WHERE `PK_Membres`= ?");
            preparedStatement.setInt(1,pk);
            result = preparedStatement.executeQuery();




        } catch (SQLException e) {
            e.printStackTrace();
            noError = false;
        } finally {
            CloseDB();
        }
        return noError;
    }





}
