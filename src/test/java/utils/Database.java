package utils;

import core.TestManager;

import java.sql.*;

/**
 * Created by ramesh on 02/12/15.
 */
public class Database {
    private static Connection connection;

    public void initialize() {
        if(connection == null) {
            try {
                Class.forName(TestManager.dbDriver());
                connection = DriverManager.getConnection(TestManager.dbUrl(), TestManager.dbUsername(), TestManager.dbPassword());
            } catch (ClassNotFoundException e) {
                Logger.exception(e);
            } catch (SQLException e) {
                Logger.exception(e);
            }
        }
    }

    private void closeConnection() {
        if(connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                Logger.exception(e);
            }
        }
    }
}
