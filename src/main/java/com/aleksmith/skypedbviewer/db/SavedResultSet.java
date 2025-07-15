package com.aleksmith.skypedbviewer.db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;

import com.aleksmith.skypedbviewer.util.Toolbox;

/**
 * Used to store the results from a ResultSet after it has been closed.
 */
public class SavedResultSet {
    
    private final ResultSet set;
    private final ResultSetMetaData meta;
    
    private String[] columnNames;    
    private HashMap<String, SqliteValue[]> results;
    private boolean ready;

    /**
     * Constructs a SavedResultSet with the specified ResultSet. The ResultSet can later
     * be read with {@code saveAll()}.
     * @param res
     */
    public SavedResultSet(ResultSet res) throws SQLException {
        set = res;
        meta = set.getMetaData();
        columnNames = null;
        results = null;
        ready = false;
    }

    /**
     * Saves all results from the ResultSet associated with this SavedResultSet. These results
     * can then be accessed with this class's accessor methods. If this method has already been
     * called previously, nothing happens.
     */
    public void saveAll() throws SQLException {
        
        if (ready) {
            return;
        }

        columnNames = Toolbox.getColumnNames(set);

        results = new HashMap<>();
        int rowCount = Toolbox.getRowCount(set);
        for (String c : columnNames) {
            results.put(c, new SqliteValue[rowCount]);
        }

        set.absolute(0);
        while (set.next()) {
            int index = set.getRow() - 1;
            for (int c = 0; c < columnNames.length; c++) {
                int type = meta.getColumnType(c);
                Object data = set.getObject(c);
                SqliteValue value = new SqliteValue(type, data);
                SqliteValue[] arr = results.get(columnNames[c]);
                arr[index] = value;
            }
        }

        ready = true;

    }

    // TODO implement accessor methods

}
