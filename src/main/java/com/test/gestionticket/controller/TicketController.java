package com.test.gestionticket.controller;

import com.test.gestionticket.exceptions.TicketNotFoundException;
import com.test.gestionticket.model.Tickets;
import com.test.gestionticket.service.TicketService;
import com.test.gestionticket.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private UserService userService;

    @Operation(summary = "Récupérer tous les tickets")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tickets récupérés"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @GetMapping
    public List<Tickets> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @Operation(summary = "Récupérer un ticket par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ticket récupéré"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') and #id == principal.id")
    public ResponseEntity<Tickets> getTicketById(@PathVariable Long id) {
        Tickets ticket = ticketService.getTicketById(id);
        return ResponseEntity.ok(ticket);
    }

    @Operation(summary = "Créer un nouveau ticket")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ticket créé"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Tickets> createTicket(@RequestBody Tickets ticket) {
        Tickets createdTicket = ticketService.createTicket(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTicket);
    }

    @Operation(summary = "Modifier un ticket")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ticket modifié"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Tickets> updateTicket(@PathVariable Long id, @RequestBody Tickets updatedTicket) {
        Tickets ticket = ticketService.updateTicket(id, updatedTicket);
        return ResponseEntity.ok(ticket);
    }

    @Operation(summary = "Supprimer un ticket")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ticket supprimé"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicketById(id);
    }

    @Operation(summary = " Assigner un ticket à un utilisateur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ticket assigné"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}/assign/{userId}")
    public ResponseEntity<String> assignTicketToUser(@PathVariable Long id, @PathVariable Long userId) {
        try {
            ticketService.assignTicketToUserId(id, userId);
            return ResponseEntity.ok("Ticket assigné à l'utilisateur ID: " + userId);
        } catch (TicketNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

}
