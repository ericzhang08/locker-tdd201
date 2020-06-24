package locker.tdd201;

import java.util.List;
import java.util.Optional;

public class RobotManager extends LockerRobot {
    private List<LockerRobot> robotRepository;

    public RobotManager(List<LockerRobot> robots, List<Locker> lockers) {
        super(lockers);
        this.robotRepository = robots;
    }


    public Ticket store(Bag bag) {
        Optional<LockerRobot> first = robotRepository.stream().filter(lockerRobot -> !lockerRobot.isFull()).findFirst();
        if (first.isPresent()) {
            return first.get().store(bag);
        }
        return super.store(bag);
    }

    @Override
    public Bag pickUp(Ticket ticket) {
        Optional<Locker> locker = lockerRepository.stream().filter(l -> l.hasTicket(ticket)).findFirst();
        if (locker.isPresent()) {
            return locker.get().pickUp(ticket);
        }
        return robotRepository.stream().filter(l -> l.hasTicket(ticket)).findFirst().orElseThrow(() -> new InvalidTicketException()).pickUp(ticket);
    }
}
