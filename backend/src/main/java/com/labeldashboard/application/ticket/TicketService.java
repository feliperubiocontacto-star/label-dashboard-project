package com.labeldashboard.application.ticket;

import com.labeldashboard.domain.ticket.*;
import com.labeldashboard.infrastructure.persistence.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public List<Ticket> findAll() {
        return repository.findAll();
    }

    public Ticket findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Ticket create(Ticket ticket) {
        return repository.save(ticket);
    }

    public Ticket update(Long id, Ticket updated) {
        Ticket existing = findById(id);

        existing.setSenderEmail(updated.getSenderEmail());
        existing.setClient(updated.getClient());
        existing.setType(updated.getType());
        existing.setDescription(updated.getDescription());
        existing.setDueDate(updated.getDueDate());
        existing.setPriority(updated.getPriority());
        existing.setThreadId(updated.getThreadId());
        existing.setApprovalToken(updated.getApprovalToken());

        if (updated.getStatus() != null) {
            if (updated.getStatus() == TicketStatus.COMPLETADO) {
                existing.markCompleted();
            } else if (updated.getStatus() == TicketStatus.EN_PROCESO) {
                existing.markInProgress();
            } else {
                existing.reopen();
            }
        }

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
