package locker.tdd201;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LockerTest {
    @Test
    public void should_get_ticket_when_save_given_lock_is_not_full() {
        Locker locker = new Locker(5);
        Bag bag = new Bag();
        Ticket ticket = locker.save(new Bag());
        assertNotNull(ticket);
    }

    @Test
    public void should_throw_LockerFullException_when_save_given_locker_is_full_by_init_size_is_zero() {
        Locker locker = new Locker(0);
        Bag bag = new Bag();
        assertThrows(LockerFullException.class, () -> locker.save(bag));
    }

    @Test
    public void should_throw_LockerFullException_when_save_given_locker_is_full_by_save_bag_more_than_size() {
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        Bag bag1 = new Bag();
        locker.save(bag);
        assertThrows(LockerFullException.class, () -> locker.save(bag1));
    }

    @Test
    public void should_get_bag_when_get_given_a_valid_ticket() {
        Locker locker = new Locker(1);
        Bag bagExpected = new Bag();
        Ticket ticket = locker.save(bagExpected);
        Bag bag = locker.get(ticket);
        assertEquals(bagExpected, bag);
    }


}
