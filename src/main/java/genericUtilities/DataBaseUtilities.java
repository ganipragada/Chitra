package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;
import java.sql.SQLException;

/**
 * This class contains database reusable methods.
 * @author 91798
 */
public class DataBaseUtilities {

    // Global connection variable (used throughout the class)
    private Connection conn;

    /**
     * Establish the database connection and store it in the global variable.
     * No return type.
     */
    public void getConnection(String url, String username, String password) {
        try {
            DriverManager.registerDriver(new Driver());
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }

    /**
     * Execute a SELECT query and return the ResultSet.
     */
    public ResultSet executeQuery(String query) {
        ResultSet result = null;
        try {
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Execute INSERT/UPDATE/DELETE queries.
     */
    public int executeUpdate(String query) {
        int rows = 0;
        try (Statement stmt = conn.createStatement()) {
            rows = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * Close the database connection.
     */
    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
