package de.dlh.lhind.exception.http;

public class ServerError extends RuntimeException {
    public ServerError(String message) {
        super(message);
    }
    public ServerError(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerError() {
        super("Internal Server Error");
    }
}
