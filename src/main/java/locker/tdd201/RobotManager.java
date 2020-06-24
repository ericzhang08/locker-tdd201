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
        if(first.isPresent()){
            return first.get().store(bag);
        }
        return lockerRepository.stream().filter(locker -> !locker.isFull()).findFirst().get().store(bag);
    }
}
