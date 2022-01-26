package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }


    public void add(Ticket ticket) {
        repository.save(ticket);
    }


    public Ticket[] findAll(String from, String to) {
        Ticket[] tickets = repository.findAll();
        Ticket[] result = new Ticket[tickets.length];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (from.equals(ticket.getFrom()) && to.equals(ticket.getTo())) {
                result[index] = ticket;
                index++;
            }
        }

        Ticket[] tmp = new Ticket[index];
        System.arraycopy(result, 0, tmp, 0, tmp.length);
        Arrays.sort(tmp);
        return tmp;
    }


    public Ticket findById(int id) {
        return repository.findById(id);
    }


    public void removeById(int id) {
        repository.removeById(id);
    }
}
