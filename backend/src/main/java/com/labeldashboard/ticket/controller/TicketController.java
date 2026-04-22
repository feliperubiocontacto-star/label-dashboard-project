package com.labeldashboard.ticket.controller;

import com.labeldashboard.ticket.dto.TicketRequest;
import com.labeldashboard.ticket.dto.TicketResponse;
import com.labeldashboard.ticket.entity.Ticket;
import com.labeldashboard.ticket.repository.TicketRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping
    public List<TicketResponse> getAll() {
        return ticketRepository.findAll().stream()
                .map(TicketResponse::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public TicketResponse getById(@PathVariable Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found"));

        return TicketResponse.fromEntity(ticket);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TicketResponse create(@RequestBody TicketRequest request) {
        Ticket ticket = new Ticket();
        mapRequest(request, ticket);

        Ticket saved = ticketRepository.save(ticket);
        return TicketResponse.fromEntity(saved);
    }

    @PutMapping("/{id}")
    public TicketResponse update(@PathVariable Long id, @RequestBody TicketRequest request) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found"));

        mapRequest(request, ticket);

        Ticket saved = ticketRepository.save(ticket);
        return TicketResponse.fromEntity(saved);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!ticketRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found");
        }

        ticketRepository.deleteById(id);
    }

    private void mapRequest(TicketRequest request, Ticket ticket) {
        ticket.setClosedAt(request.closedAt());
        ticket.setSenderEmail(request.senderEmail());
        ticket.setClient(request.client());
        ticket.setType(request.type());
        ticket.setDescription(request.description());
        ticket.setDueDate(request.dueDate());
        ticket.setStatus(request.status());
        ticket.setPriority(request.priority());
        ticket.setThreadId(request.threadId());
        ticket.setApprovalToken(request.approvalToken());
    }
}
