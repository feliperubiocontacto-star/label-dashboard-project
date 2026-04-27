package com.labeldashboard.infrastructure.persistence;

import com.labeldashboard.domain.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findByThreadId(String threadId);
}
