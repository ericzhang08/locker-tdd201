package locker.tdd201;

import java.util.List;
import java.util.Optional;

public class RobotManager {
    private List<LockerRobot> robotRepository;
    private List<Locker> lockerRepository;

    public RobotManager(List<LockerRobot> robots, List<Locker> lockers) {
        this.robotRepository = robots;
        this.lockerRepository = lockers;
    }


    public Ticket store(Bag bag) {
        Optional<LockerRobot> first = robotRepository.stream().filter(lockerRobot -> !lockerRobot.isFull()).findFirst();
        if (first.isPresent()) {
            return first.get().store(bag);
        }
        return lockerRepository.stream().filter(locker -> !locker.isFull()).findFirst().orElseThrow(AllLockersAreFullException::new).store(bag);
    }

    public Bag pickup(Ticket ticket) {

        Optional<Locker> locker = lockerRepository.stream().filter(l -> l.hasTicket(ticket)).findFirst();
        if (locker.isPresent()) {
            return locker.get().pickUp(ticket);
        }
        return robotRepository.stream().filter(l -> l.hasTicket(ticket)).findFirst().orElseThrow(() -> new InvalidTicketException()).pickUp(ticket);
    }
}
