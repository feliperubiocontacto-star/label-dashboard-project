package com.labeldashboard.infrastructure.persistence;

import com.labeldashboard.domain.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
