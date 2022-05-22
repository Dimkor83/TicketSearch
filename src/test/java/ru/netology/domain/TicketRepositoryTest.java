package ru.netology.domain;

import ru.netology.domain.Ticket;
import ru.netology.domain.TicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();
    private TicketSearchManager manager = new TicketSearchManager(repository);

    private Ticket firstTicket = new Ticket(1, 2100, "KUF", "EGO", 95);
    private Ticket secondTicket = new Ticket(2, 2110, "DME", "OGZ", 100);
    private Ticket thirdTicket = new Ticket(3, 2099, "KUF", "EGO", 110);
    private Ticket forthTicket = new Ticket(4, 2230, "DME", "OGZ", 90);
    private Ticket fifthTicket = new Ticket(5, 1890, "KUF", "EGO", 95);
    private Ticket sixthTicket = new Ticket(6, 2143, "DME", "OGZ", 85);
    private Ticket seventhTicket = new Ticket(7, 1946, "KUF", "EGO", 95);

    @BeforeEach
    void setUp() {
        manager.add(firstTicket);
        manager.add(secondTicket);
        manager.add(thirdTicket);
        manager.add(forthTicket);
        manager.add(fifthTicket);
        manager.add(sixthTicket);
        manager.add(seventhTicket);
    }

    @Test
    void shouldFindById() {
        int expected = 3;
        Ticket actual = repository.findById(3);
        assertEquals(expected, actual.getId());
    }

    @Test
    void shouldFindById1() {
        Ticket[] expected = new Ticket[]{firstTicket, secondTicket, thirdTicket, forthTicket, fifthTicket, sixthTicket, seventhTicket};
        repository.findById(9);
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldRemoveById() {
        Ticket[] expected = new Ticket[]{firstTicket, secondTicket, thirdTicket, forthTicket, fifthTicket, seventhTicket};
        repository.removeById(6);
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}