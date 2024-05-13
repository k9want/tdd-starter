package com.fastcamp.tddstarter.mockito.ticketing.service;

import com.fastcamp.tddstarter.mockito.ticketing.model.dto.Ticket;
import com.fastcamp.tddstarter.mockito.ticketing.model.entity.ticketing.Reservation;
import com.fastcamp.tddstarter.mockito.ticketing.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class TicketingService {

    private final PerformanceService performanceService;
    private final ReservationRepository reservationRepository;

    @Transactional
    public Ticket ticketing(Ticket t) {
        if ("enable".equals(performanceService.isEnableReserve(t.getPerformanceId()))) {
            reserve(t);
            return t;
        }
        throw new NoSuchElementException("예약 가능한 공연이 아닙니다.");
    }

    private void reserve(Ticket t){
        reservationRepository.save(Reservation.of(t));
    }

    private Reservation getReservedInfo(Ticket t){
        return reservationRepository.findReservationByPerformanceIdAndRoundAndGateAndLineAndSeatAndNameAndPhoneNumber(
            t.getPerformanceId(),
            t.getRound(),
            t.getGate(),
            t.getLine(),
            t.getSeat(),
            t.getReservationName(),
            t.getReservationPhoneNumber()
        );
    }

}
