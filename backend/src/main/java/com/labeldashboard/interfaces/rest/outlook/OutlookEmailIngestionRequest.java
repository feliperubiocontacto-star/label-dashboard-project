package com.labeldashboard.interfaces.rest.outlook;

import com.labeldashboard.domain.ticket.TicketPriority;
import com.labeldashboard.domain.ticket.TicketType;

import java.time.LocalDate;

public record OutlookEmailIngestionRequest(
        String messageId,
        String threadId,
        String senderEmail,
        String subject,
        String bodyPreview,
        String client,
        TicketType type,
        TicketPriority priority,
        LocalDate dueDate
) {
}
