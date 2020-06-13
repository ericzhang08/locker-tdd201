package locker.tdd201;

import java.util.HashSet;

public class Locker {
    private int size;
    private HashSet<Bag> set = new HashSet<>();

    public Locker(int size) {
        this.size = size;
    }

    public Ticket save(Bag bag) {
        if (set.size() >= size) {
            throw new LockerFullException("Licker is full");
        }
        set.add(bag);
        return new Ticket();
    }
}
