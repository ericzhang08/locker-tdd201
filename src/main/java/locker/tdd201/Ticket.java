package locker.tdd201;

import java.util.Objects;
import java.util.UUID;

public class Ticket {
    private UUID uuid;

    public Ticket() {
        this.uuid = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(uuid, ticket.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
