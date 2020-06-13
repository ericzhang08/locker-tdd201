package locker.tdd201;

import java.util.HashMap;

public class Locker {
    private int size;
    private HashMap<Ticket, Bag> map = new HashMap<>();

    public Locker(int size) {
        this.size = size;
    }

    public Ticket save(Bag bag) {
        if (map.size() >= size) {
            throw new LockerFullException("Licker is full");
        }
        Ticket ticket = new Ticket();
        map.put(ticket, bag);
        return ticket;
    }

    public Bag get(Ticket ticket) {
        if(!map.containsKey(ticket)){
            throw new InvalidTicketException();
        }
        return map.remove(ticket);
    }
}
