package locker.tdd201;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SmartLockerRobotTest {
    @Test
    public void should_store_in_first_locker_when_store_given_first_locker_unused_space_is_more_than_second() {
        Locker moreSpaceLocker = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(moreSpaceLocker, new Locker(1)));

        Bag bag = new Bag();
        Ticket ticket = smartLockerRobot.store(bag);

        assertNotNull(ticket);

        assertEquals(bag, moreSpaceLocker.pickUp(ticket));

    }
    @Test
    public void should_store_in_second_locker_when_store_given_first_locker_unused_space_is_less_than_second() {
        Locker moreSpaceLocker = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(1), moreSpaceLocker));

        Bag bag = new Bag();
        Ticket ticket = smartLockerRobot.store(bag);

        assertNotNull(ticket);

        assertEquals(bag, moreSpaceLocker.pickUp(ticket));

    }

    @Test
    public void should_store_in_first_locker_when_store_given_first_locker_unused_space_is_equal_to_second() {
        Locker firstLocker = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, new Locker(2)));

        Bag bag = new Bag();
        Ticket ticket = smartLockerRobot.store(bag);

        assertNotNull(ticket);

        assertEquals(bag, firstLocker.pickUp(ticket));

    }

    @Test
    void should_throw_exception_when_store_given_two_Locker_both_are_full() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, secondLocker));
        firstLocker.store(new Bag());
        secondLocker.store(new Bag());


        assertThrows(AllLockersAreFullException.class, () -> smartLockerRobot.store(new Bag()));

    }

    @Test
    void should_get_bag_when_pick_up_given_a_valid_ticket() {
        Locker moreSpaceLocker = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(moreSpaceLocker, new Locker(1)));
        Bag bagExpected = new Bag();
        Ticket ticket = smartLockerRobot.store(bagExpected);

        assertEquals(bagExpected, smartLockerRobot.pickUp(ticket));

    }

    @Test
    void should_throw_exception_when_pick_up_given_an_invalid_ticket() {
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(1), new Locker(1)));
        assertThrows(InvalidTicketException.class, () -> smartLockerRobot.pickUp(new Ticket()));
    }


    @Test
    void should_get_bag_when_pick_up_given_primary_locker_robot_and_smart_locker_robot_manage_the_same_locker_and_primary_store() {
        List<Locker> lockers = Collections.singletonList(new Locker(1));
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
        Bag bag = new Bag();

        Ticket ticket = primaryLockerRobot.store(bag);
        assertEquals(bag, smartLockerRobot.pickUp(ticket));
    }

}
