package locker.tdd201;

public class LockerFullException extends RuntimeException{
    public LockerFullException(String message) {
        super(message);
    }
}
