package locker.tdd201;

public class InvalidTicketException extends RuntimeException {
    public InvalidTicketException() {
        super("ticker is invalid");
    }
}
