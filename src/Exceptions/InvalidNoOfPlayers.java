package Exceptions;

public class InvalidNoOfPlayers extends RuntimeException{
    public InvalidNoOfPlayers() {
    }

    public InvalidNoOfPlayers(String message) {
        super(message);
    }

    public InvalidNoOfPlayers(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNoOfPlayers(Throwable cause) {
        super(cause);
    }

    public InvalidNoOfPlayers(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
