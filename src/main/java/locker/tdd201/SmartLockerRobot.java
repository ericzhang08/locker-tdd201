package locker.tdd201;

import java.util.List;

public class SmartLockerRobot {
    private List<Locker> lockerRepository;

    public SmartLockerRobot(List<Locker> lockers) {
        this.lockerRepository = lockers;
    }

    public Ticket store(Bag bag) {
        return lockerRepository.get(0).store(bag);
    }
}
