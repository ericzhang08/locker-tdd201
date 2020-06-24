package locker.tdd201;

import java.util.List;

public class RobotManager {
    private List<LockerRobot> robotRepository;

    public RobotManager(List<LockerRobot> robots) {
        this.robotRepository = robots;
    }

    public Ticket store(Bag bag) {
        return robotRepository.stream().filter(lockerRobot -> !lockerRobot.isFull()).findFirst().get().store(bag);
    }
}
