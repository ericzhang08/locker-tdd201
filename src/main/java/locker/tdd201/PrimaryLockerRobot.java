package locker.tdd201;

import java.util.List;

public class PrimaryLockerRobot {
    private final List<Locker> lockers;

    public PrimaryLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) {
        return lockers.stream().filter(locker -> !locker.isFull()).
                findFirst().orElseThrow(AllLockersAreFullException::new).store(bag);
    }

    public Bag pickUp(Ticket ticket) {
        return lockers.stream().filter(locker -> locker.hasTicket(ticket)).
                findFirst().orElseThrow(InvalidTicketException::new).pickUp(ticket);
    }
}
