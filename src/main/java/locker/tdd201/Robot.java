package locker.tdd201;

import java.util.List;

public class Robot {
    private final List<Locker> lockers;

    public Robot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) {
        return lockers.stream().filter(locker -> !locker.isFull()).
                findFirst().get().store(bag);
    }
}
