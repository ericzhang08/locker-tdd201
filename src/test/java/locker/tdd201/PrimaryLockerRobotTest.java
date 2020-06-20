package locker.tdd201;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PrimaryLockerRobotTest {
    @Test
    void should_get_ticket_and_save_in_first_locker_when_store_given_two_Locker_both_are_not_full() {
        Locker firstLocker = new Locker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(firstLocker, new Locker(1)));
        Bag bag = new Bag();

        Ticket ticket = primaryLockerRobot.store(bag);

        assertNotNull(ticket);
        assertEquals(bag, firstLocker.pickUp(ticket));
    }

    @Test
    void should_get_ticket_and_save_in_second_locker_when_store_given_two_Locker_first_is_full() {
        Locker firstLocker = new Locker(1);
        firstLocker.store(new Bag());
        Locker secondLocker = new Locker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(firstLocker, secondLocker));
        Bag bag = new Bag();

        Ticket ticket = primaryLockerRobot.store(bag);

        assertEquals(bag, secondLocker.pickUp(ticket));
    }

    @Test
    void should_throw_exception_when_store_given_two_Locker_both_are_full() {
        Locker firstLocker = new Locker(1);
        firstLocker.store(new Bag());
        Locker secondLocker = new Locker(1);
        secondLocker.store(new Bag());
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(firstLocker, secondLocker));

        assertThrows(AllLockersAreFullException.class, () -> primaryLockerRobot.store(new Bag()));
    }

    @Test
    void should_get_bag_when_pick_up_given_a_valid_ticket() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new Locker(1), new Locker(1)));
        Bag bag = new Bag();
        Ticket ticket = primaryLockerRobot.store(bag);
        assertEquals(bag, primaryLockerRobot.pickUp(ticket));
    }
    @Test
    void should_throw_exception_when_pick_up_given_an_invalid_ticket() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new Locker(1), new Locker(1)));
        assertThrows(InvalidTicketException.class, () -> primaryLockerRobot.pickUp(new Ticket()));
    }
}
