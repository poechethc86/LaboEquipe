package be.ifosup.database;

import be.ifosup.entities.Sport;

import java.sql.SQLException;

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
            preparedStatement = connection.prepareStatement("INSERT INTO t_sports(Nom_Sport) VALUES (?)");
            preparedStatement.setString(1,sport.getNomSport());
        } catch (SQLException e) {
            e.printStackTrace();
            noError = false;
        } finally {
            CloseDB();
        }
        return noError;
    }
}
