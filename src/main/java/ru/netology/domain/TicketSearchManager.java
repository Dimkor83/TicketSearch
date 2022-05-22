package ru.netology.domain;

import ru.netology.domain.Ticket;
import ru.netology.domain.TicketRepository;

import java.util.Arrays;

public class TicketSearchManager {
    private final TicketRepository repository;

    public TicketSearchManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket item) {
        repository.save(item);
    }


    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (ticket.getFromAirport().equals(from) && ticket.getToAirport().equals(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}