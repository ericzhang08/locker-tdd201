package locker.tdd201;

public class AllLockersAreFullException extends RuntimeException {
    public AllLockersAreFullException() {
        super("All lockers are full");
    }
}
