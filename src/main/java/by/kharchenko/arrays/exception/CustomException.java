package by.kharchenko.arrays.exception;

public class CustomException extends Exception {

    private final String messageName;

    public CustomException(String name) {
        super(name);
        messageName = name;
    }

    public CustomException(String message, String messageName) {
        super(message);
        this.messageName = messageName;
    }

    public CustomException(String message, Throwable cause, String messageName) {
        super(message, cause);
        this.messageName = messageName;
    }

    public CustomException(Throwable cause, String messageName) {
        super(cause);
        this.messageName = messageName;
    }

    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String messageName) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.messageName = messageName;
    }

    public String getMessageName() {
        return "CustomException reported that " + messageName;
    }
}
