package Exceptions;

public class InvalidNoOfSymbols extends RuntimeException{
    public InvalidNoOfSymbols() {
    }

    public InvalidNoOfSymbols(String message) {
        super(message);
    }

    public InvalidNoOfSymbols(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNoOfSymbols(Throwable cause) {
        super(cause);
    }

    public InvalidNoOfSymbols(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
