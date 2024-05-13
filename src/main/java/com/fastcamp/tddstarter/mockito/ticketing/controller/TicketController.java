package com.fastcamp.tddstarter.mockito.ticketing.controller;

import com.fastcamp.tddstarter.mockito.ticketing.model.dto.Ticket;
import com.fastcamp.tddstarter.mockito.ticketing.service.TicketingService;
import java.util.Arrays;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketController {

    private final TicketingService ticketingService;

    @PostMapping("/reserve")
    public ResponseEntity<Ticket> reservation() throws Exception {
        Ticket ticket = Ticket.builder()
            .performanceId(UUID.fromString(UUID.randomUUID().toString()))
            .performanceName("상권")
            .reservationName("sangkwon")
            .reservationPhoneNumber("010-1234-1234")
            .reservationStatus("reserve")
            .round(1)
            .line('A')
            .seat(1)
            .appliedPolicies(Arrays.asList(new String[]{"telecom"}))
            .build();
        System.out.println("reservation");

        return ResponseEntity.ok()
            .body(ticketingService.ticketing(ticket));
    }
}
