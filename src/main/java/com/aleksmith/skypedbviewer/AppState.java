package com.aleksmith.skypedbviewer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppState {

    public static final String JDBC_PROTOCOL = "jdbc:sqlite:";

    private Connection conn;

    public AppState() {
        this.conn = null;
    }

    /**
     * Returns the current database connection, or null if no connection has been
     * established yet. This method will return the connection whether or not it
     * has been closed, so this should be checked before using the connection.
     * @return the connection, or null if there is no connection
     */
    public Connection getConnection() {
        return conn;
    }

    /**
     * Creates a new database connection, replacing the previous one if it exists.
     * The newly created connection is returned, or null is returned if the connection
     * couldn't be created, or if the previous connection couldn't be closed.
     * @return the newly-created connection, or null if creation failed
     */
    public Connection newConnection(String path) {

        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
            conn = DriverManager.getConnection(JDBC_PROTOCOL + path);
            return conn;
        } catch (SQLException e) {
            return null;
        }
        
    }

}
