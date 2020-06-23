package locker.tdd201;

import java.util.List;

public class SmartLockerRobot extends LockerRobot {

    public SmartLockerRobot(List<Locker> lockers) {
        super(lockers);
    }

    public Bag pickUp(Ticket ticket) {
        return lockerRepository.stream().filter(locker -> locker.hasTicket(ticket)).
                findFirst().orElseThrow(InvalidTicketException::new).pickUp(ticket);
    }
}
