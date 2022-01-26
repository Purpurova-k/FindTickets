package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket ticketSpbMoscow = new Ticket(1, 2165, "LED", "DME", 105);
    private Ticket ticketSpbMoscow2 = new Ticket(2, 3165, "LED", "DME", 105);
    private Ticket ticketSpbMoscow3 = new Ticket(3, 4165, "LED", "DME", 105);
    private Ticket ticketSochiSpb = new Ticket(4, 5105, "AER", "LED", 185);
    private Ticket ticketStavropolRnd = new Ticket(5, 8350, "STW", "ROV", 115);
    private Ticket ticketSpbNovosibirsk = new Ticket(6, 4100, "LED", "OVB", 255);


    @Test
    public void shouldFindAllTicketsSort() {
        manager.add(ticketSpbMoscow2);
        manager.add(ticketSpbMoscow3);
        manager.add(ticketSochiSpb);
        manager.add(ticketSpbMoscow);
        manager.add(ticketSpbNovosibirsk);
        manager.add(ticketStavropolRnd);

        Ticket[] actual = manager.findAll("LED", "DME");
        Ticket[] expected = {ticketSpbMoscow, ticketSpbMoscow2, ticketSpbMoscow3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTicketsInvalidFrom() {
        manager.add(ticketSpbMoscow2);
        manager.add(ticketSpbMoscow3);
        manager.add(ticketSochiSpb);
        manager.add(ticketSpbMoscow);
        manager.add(ticketSpbNovosibirsk);
        manager.add(ticketStavropolRnd);

        Ticket[] actual = manager.findAll("ROV", "LED");
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTicketsInvalidTo() {
        manager.add(ticketSpbMoscow2);
        manager.add(ticketSpbMoscow3);
        manager.add(ticketSochiSpb);
        manager.add(ticketSpbMoscow);
        manager.add(ticketSpbNovosibirsk);
        manager.add(ticketStavropolRnd);

        Ticket[] actual = manager.findAll("LED", "STW");
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }
}