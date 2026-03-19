package be.kdg.portfolio.ex3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoUtils {
    public static void loadDriver() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            throw new DiceDaoException("Kan driver niet laden", e);
        }
    }

    public static Connection createConnection() {
        try {
            // Let op: 'db/diceDB' maakt een map 'db' aan in je project root
            return DriverManager.getConnection("jdbc:hsqldb:file:db/diceDB", "sa", "");
        } catch (SQLException e) {
            throw new DiceDaoException("Kan geen verbinding maken", e);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                statement.execute("SHUTDOWN");
                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            throw new DiceDaoException("Kan verbinding niet sluiten", e);
        }
    }
}
