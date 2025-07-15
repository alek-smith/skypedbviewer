package com.aleksmith.skypedbviewer.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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

    /**
     * Retrieves all column names from a given ResultSet.
     * @param res the ResultSet
     * @return an array of column names
     */
    public static String[] getColumnNames(ResultSet res) throws SQLException {

        ResultSetMetaData meta = res.getMetaData();
        int columnCount = meta.getColumnCount();
        String[] names = new String[columnCount];
        
        for (int c = 0; c < columnCount; c++) {
            names[c] = meta.getColumnName(c);
        }

        return names;

    }

    /**
     * Retrieves the number of entries from the given ResultSet.
     * @param res the ResultSet
     * @return the number of entries
     * @throws SQLException if an SQL error occured
     */
    public static int getRowCount(ResultSet res) throws SQLException {

        int curr = res.getRow();
        res.last();
        int count = res.getRow();
        res.absolute(curr);
        return count;

    }

}
