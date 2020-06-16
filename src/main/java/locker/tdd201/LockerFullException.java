package locker.tdd201;

public class LockerFullException extends RuntimeException{
    public LockerFullException() {
        super("locker is full");
    }
}
