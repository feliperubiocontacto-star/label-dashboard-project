package com.labeldashboard.interfaces.rest.outlook;

import com.labeldashboard.application.ticket.TicketService;
import com.labeldashboard.domain.ticket.Ticket;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/outlook")
@CrossOrigin(origins = "*")
public class OutlookController {

    private final TicketService service;

    public OutlookController(TicketService service) {
        this.service = service;
    }

    @PostMapping("/ingest")
    public Ticket ingest(@RequestBody OutlookEmailIngestionRequest request) {
        return service.createFromEmail(request);
    }
}
