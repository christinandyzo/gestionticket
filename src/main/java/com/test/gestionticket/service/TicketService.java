package com.test.gestionticket.service;

import com.test.gestionticket.model.Tickets;

import java.util.List;

public interface TicketService {
    Tickets getTicketById(Long id);
    List<Tickets> getAllTickets();
    Tickets createTicket(Tickets ticket);
    Tickets updateTicket(Long id, Tickets ticket);
    void deleteTicketById(Long id);
    List<Tickets> getTicketsForUser(Long id);
    void assignTicketToUserId(Long ticketId, Long userId);
}
