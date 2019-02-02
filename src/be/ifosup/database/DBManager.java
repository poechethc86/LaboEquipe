package be.ifosup.database;

import java.sql.*;

public class DBManager {
    protected String url = "jdbc:mysql://localhost:3306/sport?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    protected String dbUser = "root";
    protected String dbPass = "";

    protected Connection connection = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet result = null;

    private boolean driverloaded = false;

    protected boolean LoadDriver () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver OK");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            return false;
        }
        return true;
    }

    protected boolean ConnectDB () {
        if (!driverloaded) {
            driverloaded = LoadDriver();
        }
        if (driverloaded) {
            try {
                connection = DriverManager.getConnection(url, dbUser, dbPass);
                System.out.println("Connection OK");
            } catch (SQLException e) {
                System.out.println("Impossible to connect DB");
                return false;
            }
            return true;
        }
        return false;
    }

    protected void CloseDB () {
        if (result != null) {
            try {
                result.close();
            } catch (SQLException ignore) {
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException ignore) {
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ignore) {
            }
        }
    }
}
