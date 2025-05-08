package com.aleksmith.skypedbviewer;

import java.sql.Connection;
import java.sql.SQLException;

import com.aleksmith.skypedbviewer.exception.ConnectionClosedException;

public class Toolbox {

    public static void enforceConnectionOpen(Connection conn) throws SQLException {
        if (conn == null) {
            throw new NullPointerException("no connection");
        } else if (conn.isClosed()) {
            throw new ConnectionClosedException("connection closed");
        }
    }

}
