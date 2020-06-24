package locker.tdd201;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LockerRobotManagerTest {
    @Test
    void should_store_in_first_robot_and_get_ticket_when_store_given_two_not_full_robot() {
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(1)));
        RobotManager robotManager = new RobotManager(Arrays.asList(smartLockerRobot));
        Bag bag = new Bag();
        Ticket ticket = robotManager.store(bag);
        assertEquals(smartLockerRobot.pickUp(ticket), bag);
    }
}
