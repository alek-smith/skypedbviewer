package com.aleksmith.skypedbviewer.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Used to store the results from a ResultSet after it has been closed.
 */
public class SavedResultSet {
    
    private final String[] columnNames;
    private final HashMap<String, Object>[] results;
    private final ResultSet set;
    
    private boolean ready;

    /**
     * Constructs a SavedResultSet with the specified ResultSet. The ResultSet can later
     * be read with {@code saveAll()}.
     * @param res
     */
    public SavedResultSet(ResultSet res) throws SQLException {
        set = res;
        columnNames = null;
        results = null;
        ready = false;
    }

    /**
     * Saves all results from the ResultSet associated with this SavedResultSet. These results
     * can then be accessed with this class's accessor methods. If this method has already been
     * called previously, nothing happens.
     */
    public void saveAll() {
        
        if (ready) {
            return;
        }

        // TODO implement

        ready = true;
    }

    // TODO implement accessor methods

}
