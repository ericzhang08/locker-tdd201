package locker.tdd201;

import java.util.Comparator;
import java.util.List;

public abstract class LockerRobot {

    public List<Locker> lockerRepository;

    public LockerRobot(List<Locker> lockers) {
        this.lockerRepository = lockers;
    }

    public Ticket store(Bag bag) {
        return lockerRepository.stream().filter(locker -> !locker.isFull())
                .max(Comparator.comparingInt(Locker::getUnusedSpace)).
                        orElseThrow(AllLockersAreFullException::new).store(bag);
    }

    public abstract Bag pickUp(Ticket ticket);

    public boolean isFull(){
        return lockerRepository.stream().filter(locker -> !locker.isFull()).findFirst().isEmpty();
    }

}
