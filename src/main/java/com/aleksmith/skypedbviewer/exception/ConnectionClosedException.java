package com.aleksmith.skypedbviewer.exception;

public class ConnectionClosedException extends RuntimeException {

    public ConnectionClosedException() {
        super();
    }

    public ConnectionClosedException(String msg) {
        super(msg);
    }

    public ConnectionClosedException(Throwable t) {
        super(t);
    }

    public ConnectionClosedException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
