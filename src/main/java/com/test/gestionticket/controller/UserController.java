package com.test.gestionticket.controller;


import com.test.gestionticket.model.Tickets;
import com.test.gestionticket.model.Users;
import com.test.gestionticket.service.TicketService;
import com.test.gestionticket.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TicketService ticketService;

    @Operation(summary = "Récupérer tous les utilisateur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Utilisateurs récupérés"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Récupérer un utilisateur par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Utilisateur récupéré"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        Users user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Créer un utilisateur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Utilisateur créé"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        Users newUser  = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @Operation(summary = "Modifier un utilisateur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Utilisateur modifié"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users updatedUser) {
        Users user = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Supprimer un utilisateur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Utilisateur supprimé"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @Operation(summary = "Récupérer les tickets assignés à l'utilisateur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ticket résupéreé"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @GetMapping("/{id}/ticket")
    public List<Tickets> getTicketsForUser(@PathVariable Long id) {
        return ticketService.getTicketsForUser(id);
    }

}
