package locker.tdd201;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LockerRobotManagerTest {
    @Test
    void should_store_in_first_robot_and_get_ticket_when_store_given_two_not_full_robot() {
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(1)));
        RobotManager robotManager = new RobotManager(Arrays.asList(smartLockerRobot), Arrays.asList());
        Bag bag = new Bag();
        Ticket ticket = robotManager.store(bag);
        assertNotNull(ticket);
        assertEquals(smartLockerRobot.pickUp(ticket), bag);
    }
    @Test
    void should_store_in_second_robot_and_get_ticket_when_store_given_first_robot_is_full_and_second_is_not_full_() {
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(1)));
        smartLockerRobot.store(new Bag());
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new Locker(1)));
        RobotManager robotManager = new RobotManager(Arrays.asList(smartLockerRobot, primaryLockerRobot), Arrays.asList());

        Bag bag = new Bag();
        Ticket ticket = robotManager.store(bag);
        assertNotNull(ticket);
        assertEquals(primaryLockerRobot.pickUp(ticket), bag);
    }

    @Test
    void should_store_in_first_locker_and_get_ticket_when_store_given_two_not_full_lockers() {
        Locker firstLocker = new Locker(1);
        RobotManager robotManager = new RobotManager(Arrays.asList(), Arrays.asList(firstLocker, new Locker(1)));

        Bag bag = new Bag();
        Ticket ticket = robotManager.store(bag);
        assertEquals(firstLocker.pickUp(ticket), bag);
    }

}
