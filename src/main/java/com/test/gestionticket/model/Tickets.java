package com.test.gestionticket.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private TicketStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private Users assignedUser;

    public Tickets() {
    }

    public Tickets(Long id, String title, String description, TicketStatus status, Users assignedUser) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.assignedUser = assignedUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public Users getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(Users assignedUser) {
        this.assignedUser = assignedUser;
    }

}
