package Exceptions;

public class NoMoreCells extends RuntimeException{
    public NoMoreCells() {
    }

    public NoMoreCells(String message) {
        super(message);
    }

    public NoMoreCells(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMoreCells(Throwable cause) {
        super(cause);
    }

    public NoMoreCells(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
