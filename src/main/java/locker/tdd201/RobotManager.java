package locker.tdd201;

import java.util.List;

public class RobotManager {
    private List<SmartLockerRobot> robotRepository;

    public RobotManager(List<SmartLockerRobot> robots) {
        this.robotRepository = robots;
    }

    public Ticket store(Bag bag) {
        return robotRepository.get(0).store(bag);
    }
}
