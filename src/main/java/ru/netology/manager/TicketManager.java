package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

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
        Ticket[] tmp = new Ticket[tickets.length];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (from.equals(ticket.getFrom()) && to.equals(ticket.getTo())) {
                tmp[index] = ticket;
                index++;
            }
        }

        Ticket[] result = new Ticket[index];
        System.arraycopy(tmp, 0, result, 0, result.length);
        Arrays.sort(result);
        return result;
    }


    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] tickets = repository.findAll();
        Ticket[] tmp = new Ticket[tickets.length];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (from.equals(ticket.getFrom()) && to.equals(ticket.getTo())) {
                tmp[index] = ticket;
                index++;
            }
        }

        Ticket[] result = new Ticket[index];
        System.arraycopy(tmp, 0, result, 0, result.length);
        Arrays.sort(result, comparator);
        return result;
    }



    public Ticket findById(int id) {
        return repository.findById(id);
    }


    public void removeById(int id) {
        repository.removeById(id);
    }
}
