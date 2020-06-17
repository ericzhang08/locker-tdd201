package locker.tdd201;

import java.util.HashMap;

public class Locker {
    private int size;
    private HashMap<Ticket, Bag> bagRepository = new HashMap<>();

    public Locker(int size) {
        this.size = size;
    }

    public Ticket store(Bag bag) {
        if (isFull()) {
            throw new LockerFullException();
        }
        Ticket ticket = new Ticket();
        bagRepository.put(ticket, bag);
        return ticket;
    }

    public Bag pickUp(Ticket ticket) {
        if(!hasTicket(ticket)){
            throw new InvalidTicketException();
        }
        return bagRepository.remove(ticket);
    }

    public boolean isFull() {
        return bagRepository.size() >= size;
    }

    public boolean hasTicket(Ticket ticket) {
        return bagRepository.containsKey(ticket);
    }
}
