package be.kdg.portfolio.ex3.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThrowsDao {
    private Connection connection;

    public ThrowsDao() {
        DaoUtils.loadDriver();
        this.connection = DaoUtils.createConnection();
        createTable();
    }

    private void createTable() {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS Throws (" +
                    "id INTEGER IDENTITY, " +
                    "result INTEGER, " +
                    "min_val INTEGER, " +
                    "max_val INTEGER)");
        } catch (SQLException e) {
            // Tabel bestaat waarschijnlijk al
        }
    }

    public void create(DieThrow dieThrow) {
        String query = String.format("INSERT INTO Throws VALUES (NULL, %d, %d, %d)",
                dieThrow.getResult(), dieThrow.getMin(), dieThrow.getMax());
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(query);
            ResultSet rs = stmt.executeQuery("CALL IDENTITY()");
            if (rs.next()) dieThrow.setId(rs.getInt(1));
        } catch (SQLException e) {
            throw new DiceDaoException("Opslaan mislukt", e);
        }
    }

    public List<DieThrow> retrieveAll() {
        List<DieThrow> results = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Throws")) {
            while (rs.next()) {
                DieThrow dt = new DieThrow(rs.getInt("result"), rs.getInt("min_val"), rs.getInt("max_val"));
                dt.setId(rs.getInt("id"));
                results.add(dt);
            }
            return results;
        } catch (SQLException e) {
            throw new DiceDaoException("Ophalen mislukt", e);
        }
    }

    public void close() { DaoUtils.closeConnection(connection); }
}