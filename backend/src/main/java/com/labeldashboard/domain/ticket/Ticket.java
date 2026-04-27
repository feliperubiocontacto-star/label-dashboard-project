package com.labeldashboard.domain.ticket;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime closedAt;

    private String senderEmail;
    private String client;

    @Enumerated(EnumType.STRING)
    private TicketType type;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @Enumerated(EnumType.STRING)
    private TicketPriority priority;

    private String threadId;
    private String approvalToken;

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (status == null) {
            status = TicketStatus.PENDIENTE;
        }
    }

    public void markCompleted() {
        this.status = TicketStatus.COMPLETADO;
        if (this.closedAt == null) {
            this.closedAt = LocalDateTime.now();
        }
    }

    public void markInProgress() {
        this.status = TicketStatus.EN_PROCESO;
    }

    public void reopen() {
        this.status = TicketStatus.PENDIENTE;
        this.closedAt = null;
    }

    // getters and setters omitted for brevity
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getClosedAt() { return closedAt; }
    public void setClosedAt(LocalDateTime closedAt) { this.closedAt = closedAt; }

    public String getSenderEmail() { return senderEmail; }
    public void setSenderEmail(String senderEmail) { this.senderEmail = senderEmail; }

    public String getClient() { return client; }
    public void setClient(String client) { this.client = client; }

    public TicketType getType() { return type; }
    public void setType(TicketType type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public TicketStatus getStatus() { return status; }
    public void setStatus(TicketStatus status) { this.status = status; }

    public TicketPriority getPriority() { return priority; }
    public void setPriority(TicketPriority priority) { this.priority = priority; }

    public String getThreadId() { return threadId; }
    public void setThreadId(String threadId) { this.threadId = threadId; }

    public String getApprovalToken() { return approvalToken; }
    public void setApprovalToken(String approvalToken) { this.approvalToken = approvalToken; }
}
