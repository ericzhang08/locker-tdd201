package locker.tdd201;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RobotTest {
    @Test
    void should_get_ticket_and_save_in_first_locker_when_store_given_two_Locker_both_are_not_full() {
        Locker firstLocker = new Locker(1);
        Robot robot = new Robot(Arrays.asList(firstLocker, new Locker(1)));
        Bag bag = new Bag();
        Ticket ticket = robot.store(bag);
        assertNotNull(ticket);
        assertEquals(bag, firstLocker.pickUp(ticket));
    }
}
