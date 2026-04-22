package com.labeldashboard.ticket.dto;

import com.labeldashboard.ticket.entity.Ticket;
import com.labeldashboard.ticket.entity.TicketPriority;
import com.labeldashboard.ticket.entity.TicketStatus;
import com.labeldashboard.ticket.entity.TicketType;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record TicketResponse(
        Long id,
        LocalDateTime createdAt,
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
    public static TicketResponse fromEntity(Ticket ticket) {
        return new TicketResponse(
                ticket.getId(),
                ticket.getCreatedAt(),
                ticket.getClosedAt(),
                ticket.getSenderEmail(),
                ticket.getClient(),
                ticket.getType(),
                ticket.getDescription(),
                ticket.getDueDate(),
                ticket.getStatus(),
                ticket.getPriority(),
                ticket.getThreadId(),
                ticket.getApprovalToken()
        );
    }
}
