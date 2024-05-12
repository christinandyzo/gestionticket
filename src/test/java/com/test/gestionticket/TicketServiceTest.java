package com.test.gestionticket;

import com.test.gestionticket.model.TicketStatus;
import com.test.gestionticket.model.Tickets;
import com.test.gestionticket.model.Users;
import com.test.gestionticket.repository.TicketRepository;
import com.test.gestionticket.service.TicketService;
import com.test.gestionticket.service.TicketServiceImpl;
import com.test.gestionticket.service.UserService;

import java.util.Optional;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TicketServiceTest {

    @Test
    public void testCreateTicket() {
        Tickets ticket = new Tickets(11L,"Titre du ticket", "Description du ticket", TicketStatus.IN_PROGRESS, new Users());

        assertNotNull(ticket);
        assertEquals("Titre du ticket", ticket.getTitle());
        assertEquals("Description du ticket", ticket.getDescription());
        assertEquals(TicketStatus.IN_PROGRESS, ticket.getStatus());
        assertNotNull(ticket.getAssignedUser());
    }

    @Test
    public void testUpdateTicket() {
        Tickets ticket = new Tickets(12L,"Titre initial", "Description initiale", TicketStatus.IN_PROGRESS, new Users());

        ticket.setTitle("Nouveau titre");
        ticket.setDescription("Nouvelle description");
        ticket.setStatus(TicketStatus.COMPLETED);
        ticket.setAssignedUser(new Users());

        assertEquals("Nouveau titre", ticket.getTitle());
        assertEquals("Nouvelle description", ticket.getDescription());
        assertEquals(TicketStatus.COMPLETED, ticket.getStatus());
        assertNotNull(ticket.getAssignedUser());
    }

    @Test
    public void testGetTicketById() {
        // Créer un mock du repository de tickets
        TicketRepository ticketRepository = mock(TicketRepository.class);
        // Créer un mock du repository de users
        UserService userService = mock(UserService.class);

        // Créer un ticket fictif pour le test
        Tickets testTicket = new Tickets(1L, "Titre du ticket", "Description du ticket", TicketStatus.IN_PROGRESS, new Users());

        // Définir le comportement du mock pour retourner le ticket fictif
        when(ticketRepository.findById(1L)).thenReturn(Optional.of(testTicket));

        // Créer une instance du service de tickets
        TicketService ticketService = new TicketServiceImpl(ticketRepository, userService);

        // Appeler la méthode à tester
        Tickets retrievedTicket = ticketService.getTicketById(1L);

        // Vérifier que le ticket retourné correspond au ticket fictif
        assertEquals("Titre du ticket", retrievedTicket.getTitle());
        assertEquals("Description du ticket", retrievedTicket.getDescription());
        assertEquals(TicketStatus.IN_PROGRESS, retrievedTicket.getStatus());
    }

}
