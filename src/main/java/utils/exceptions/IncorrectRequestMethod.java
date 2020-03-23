package utils.exceptions;

public class IncorrectRequestMethod extends Exception {

    public IncorrectRequestMethod() {
    }

    public IncorrectRequestMethod(String message) {
        super(message);
    }

    public IncorrectRequestMethod(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectRequestMethod(Throwable cause) {
        super(cause);
    }

    public IncorrectRequestMethod(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}