package locker.tdd201;

import java.util.Comparator;
import java.util.List;

public class SmartLockerRobot {
    private List<Locker> lockerRepository;

    public SmartLockerRobot(List<Locker> lockers) {
        this.lockerRepository = lockers;
    }

    public Ticket store(Bag bag) {
        return lockerRepository.stream().filter(locker -> !locker.isFull())
                .max(Comparator.comparingInt(Locker::getUnusedSpace)).
                        orElseThrow(AllLockersAreFullException::new).store(bag);
    }
}
