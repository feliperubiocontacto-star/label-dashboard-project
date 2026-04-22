package com.labeldashboard.ticket.dto;

import com.labeldashboard.ticket.entity.TicketPriority;
import com.labeldashboard.ticket.entity.TicketStatus;
import com.labeldashboard.ticket.entity.TicketType;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record TicketRequest(
        LocalDateTime closedAt,
        String senderEmail,
        String client,
        TicketType type,
        String description,
        LocalDate dueDate,
        TicketStatus status,
        TicketPriority priority,
        String threadId,
        String approvalToken
) {
}
