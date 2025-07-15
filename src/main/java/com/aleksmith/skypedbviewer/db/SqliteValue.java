package com.aleksmith.skypedbviewer.db;

public class SqliteValue {
    
    private final int type;
    private final Object data;

    SqliteValue(int type, Object data) {
        this.type = type;
        this.data = data;
    }

    public <T> T getData() {
        return (T) data;
    }

    public int getType() {
        return type;
    }

}
