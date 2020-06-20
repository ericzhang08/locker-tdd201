package locker.tdd201;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
//    @Test
    public void should_store_in_second_locker_when_store_given_first_locker_unused_space_is_less_than_second() {
        Locker moreSpaceLocker = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(1), moreSpaceLocker));

        Bag bag = new Bag();
        Ticket ticket = smartLockerRobot.store(bag);

        assertNotNull(ticket);

        assertEquals(bag, moreSpaceLocker.pickUp(ticket));

    }

}
