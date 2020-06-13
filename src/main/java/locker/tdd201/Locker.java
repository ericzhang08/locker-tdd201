package locker.tdd201;

public class Locker {
    private int size;

    public Locker(int size) {
        this.size = size;
    }

    public Ticket save(Bag bag) {
        if (size == 0) {
            throw new LockerFullException("Licker is full");
        }
        return new Ticket();
    }
}
