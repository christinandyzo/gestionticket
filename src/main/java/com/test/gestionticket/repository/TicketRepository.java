package com.test.gestionticket.repository;

import com.test.gestionticket.model.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TicketRepository extends JpaRepository<Tickets, Long> {
    Tickets findById(int id);
    List<Tickets> findAll();
    Tickets deleteById(int id);
    Tickets save(Tickets tickets);
    List<Tickets> findByAssignedUserId(Long id);

}
