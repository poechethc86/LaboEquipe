package be.ifosup.database;

import be.ifosup.Utils.MD5Manager;

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
}
