package locker.tdd201;

import java.util.HashMap;

public class Locker {
    private int size;
    private HashMap<Ticket, Bag> map = new HashMap<>();

    public Locker(int size) {
        this.size = size;
    }

    public Ticket store(Bag bag) {
        if (isFull()) {
            throw new LockerFullException();
        }
        Ticket ticket = new Ticket();
        map.put(ticket, bag);
        return ticket;
    }

    public Bag pickUp(Ticket ticket) {
        if(!hasTicket(ticket)){
            throw new InvalidTicketException();
        }
        return map.remove(ticket);
    }

    public boolean isFull() {
        return map.size() >= size;
    }

    public boolean hasTicket(Ticket ticket) {
        return map.containsKey(ticket);
    }
}
