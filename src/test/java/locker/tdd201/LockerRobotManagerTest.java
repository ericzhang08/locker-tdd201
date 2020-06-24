package locker.tdd201;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_store_in_second_locker_and_get_ticket_when_store_given_two_lockers_first_is_full() {
        Locker firstLocker = new Locker(1);
        firstLocker.store(new Bag());
        Locker secondLocker = new Locker(1);
        RobotManager robotManager = new RobotManager(Arrays.asList(), Arrays.asList(firstLocker, secondLocker));

        Bag bag = new Bag();
        Ticket ticket = robotManager.store(bag);
        assertEquals(secondLocker.pickUp(ticket), bag);
    }


    @Test
    void should_store_in_robot_and_get_ticket_when_store_given_one_robot_and_one_locker_both_are_not_full() {
        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(new Locker(1)));
        RobotManager robotManager = new RobotManager(Arrays.asList(robot), Arrays.asList(new Locker(1)));

        Bag bag = new Bag();
        Ticket ticket = robotManager.store(bag);
        assertEquals(robot.pickUp(ticket), bag);
    }

    @Test
    void should_store_in_locker_and_get_ticket_when_store_given_one_robot_is_full_and_one_locker_is_not_full() {
        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(new Locker(1)));
        robot.store(new Bag());
        Locker locker = new Locker(1);
        RobotManager robotManager = new RobotManager(Arrays.asList(robot), Arrays.asList(locker));

        Bag bag = new Bag();
        Ticket ticket = robotManager.store(bag);
        assertEquals(locker.pickUp(ticket), bag);
    }

    @Test
    void should_throw_exception_when_store_given_robot_and_lockers_both_are_full() {
        Locker firstLocker = new Locker(1);
        firstLocker.store(new Bag());
        Locker secondLocker = new Locker(1);
        secondLocker.store(new Bag());
        RobotManager robotManager = new RobotManager(Arrays.asList(new PrimaryLockerRobot(Arrays.asList(firstLocker))), Arrays.asList(secondLocker));

        assertThrows(AllLockersAreFullException.class, () -> robotManager.store(new Bag()));
    }

    @Test
    void should_get_bag_when_pick_up_given_a_locker_and_a_valid_ticket() {
        RobotManager robotManager = new RobotManager(Arrays.asList(), Arrays.asList(new Locker(1)));
        Bag bag = new Bag();
        Ticket ticket = robotManager.store(bag);

        assertEquals(robotManager.pickup(ticket), bag);

    }

    @Test
    void should_get_bag_when_pick_up_given_a_robot_and_a_valid_ticket() {
        RobotManager robotManager = new RobotManager(Arrays.asList(new PrimaryLockerRobot(Arrays.asList(new Locker(1)))), Arrays.asList());
        Bag bag = new Bag();
        Ticket ticket = robotManager.store(bag);

        assertEquals(robotManager.pickup(ticket), bag);

    }

    @Test
    void should_throw_InvalidTicketException_when_pick_up_given_a_robot_and_a_locker() {
        RobotManager robotManager = new RobotManager(Arrays.asList(new PrimaryLockerRobot(Arrays.asList(new Locker(1)))), Arrays.asList(new Locker(1)));


        assertThrows(InvalidTicketException.class, () ->robotManager.pickup(new Ticket()));

    }


}
