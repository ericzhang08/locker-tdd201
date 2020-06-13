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
}
