package com.aleksmith.skypedbviewer.db;

import java.sql.ResultSet;

import com.aleksmith.skypedbviewer.AppState;

public interface DatabaseDriver {
    
    public boolean execute(AppState state, String sql);

    // TODO should return custom results object instead of ResultSet
    public ResultSet executeQuery(AppState state, String sql);

}
