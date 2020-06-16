package locker.tdd201;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LockerTest {
    @Test
    public void should_get_ticket_when_save_given_lock_is_not_full() {
        Locker locker = new Locker(5);
        Ticket ticket = locker.store(new Bag());
        assertNotNull(ticket);
    }

    @Test
    public void should_throw_LockerFullException_when_save_given_locker_is_full_by_save_bag_more_than_size() {
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        Bag bag1 = new Bag();
        locker.store(bag);
        assertThrows(LockerFullException.class, () -> locker.store(bag1));
    }

    @Test
    public void should_get_bag_when_get_given_a_valid_ticket() {
        Locker locker = new Locker(1);
        Bag bagExpected = new Bag();
        Ticket ticket = locker.store(bagExpected);
        Bag bag = locker.pickUp(ticket);
        assertEquals(bagExpected, bag);
    }

    @Test
    public void should_throw_invalidTicketException_when_get_given_an_invalid_ticket() {
        Locker locker = new Locker(1);
        Ticket ticket = new Ticket();
        assertThrows(InvalidTicketException.class, () -> locker.pickUp(ticket));
    }

    @Test
    public void should_throw_invalidTicketException_when_get_given_an_reused_ticket() {
        Locker locker = new Locker(1);
        Ticket ticket = locker.store(new Bag());
        locker.pickUp(ticket);
        assertThrows(InvalidTicketException.class, () -> locker.pickUp(ticket));
    }

    @Test
    public void should_return_true_when_is_full_given_a_full_locker() {
        Locker locker = new Locker(1);
        locker.store(new Bag());
        assertTrue(locker.isFull());
    }

    @Test
    public void should_return_false_when_is_full_given_a_locker_is_not_full() {
        Locker locker = new Locker(1);
        assertFalse(locker.isFull());
    }

    @Test
    public void should_return_true_when_has_ticket_given_a_locker_has_specify_ticker() {
        Locker locker = new Locker(1);
        Ticket ticket = locker.store(new Bag());
        assertTrue(locker.hasTicker(ticket));
    }




}
