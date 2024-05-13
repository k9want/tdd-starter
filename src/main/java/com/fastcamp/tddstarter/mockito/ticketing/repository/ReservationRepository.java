package com.fastcamp.tddstarter.mockito.ticketing.repository;

import com.fastcamp.tddstarter.mockito.ticketing.model.entity.ticketing.Reservation;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findReservationByNameAndPhoneNumber(String name, String phoneNumber);
    Reservation findReservationByPerformanceIdAndRoundAndGateAndLineAndSeatAndNameAndPhoneNumber(UUID performanceId, int round, int gate, char line, int seat, String userName, String phoneNumber);
}
