package com.test.gestionticket.service;

import com.test.gestionticket.exceptions.TicketNotFoundException;
import com.test.gestionticket.model.Tickets;
import com.test.gestionticket.model.Users;
import com.test.gestionticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final UserService userService;

    public TicketServiceImpl(TicketRepository ticketRepository, UserService userService) {
        this.ticketRepository = ticketRepository;
        this.userService = userService;
    }

    @Override
    // Récupérer un ticket par son ID
    public Tickets getTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));
    }

    @Override
    // Récupérer tous les tickets
    public List<Tickets> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    // Créer un nouveau ticket
    public Tickets createTicket(Tickets ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    // Mettre à jour un ticket existant
    public Tickets updateTicket(Long id, Tickets ticket) {
        Tickets existingTicket = ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));
        return ticketRepository.save(existingTicket);
    }

    @Override
    // Supprimer un ticket par son ID
    public void deleteTicketById(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    // Récupérer les tickets assignés à l'utilisateur
    public List<Tickets> getTicketsForUser(Long id) {
        return ticketRepository.findByAssignedUserId(id);
    }

    @Override
    // Assigner le ticket à l'utilisateur
    public void assignTicketToUserId(Long ticketId, Long userId) {
        Users user = userService.getUserById(userId);
        Tickets assignTicket = ticketRepository.findById(ticketId).orElseThrow(() -> new TicketNotFoundException(ticketId));
        assignTicket.setAssignedUser(user);
        ticketRepository.save(assignTicket);
    }

}
