package com.fastcamp.tddstarter.mockito;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fastcamp.tddstarter.mockito.ticketing.model.dto.Ticket;
import com.fastcamp.tddstarter.mockito.ticketing.repository.ReservationRepository;
import com.fastcamp.tddstarter.mockito.ticketing.service.PerformanceService;
import com.fastcamp.tddstarter.mockito.ticketing.service.TicketingService;
import java.util.Arrays;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockitoTicketingServiceTests {

    @Mock
    PerformanceService performanceService;
    @Mock
    ReservationRepository reservationRepository;
    @InjectMocks
    private TicketingService ticketingService;

    @Test
    void ticketingTest() {
        when(performanceService.isEnableReserve(any()))
            .then(invocationOnMock -> {
                System.out.println("Execute Mocking Code");
                return "enable";
            });

        // 호출이 되는 것을 기대하며 메서드에 대한 기대 행위를 명시
        Ticket t = Ticket.builder()
            .performanceId(UUID.fromString(UUID.randomUUID().toString()))
            .performanceName("모킹테스트")
            .reservationName("이상권")
            .reservationPhoneNumber("010-1234-1234")
            .reservationStatus("reserve")
            .round(1)
            .line('A')
            .seat(1)
            .appliedPolicies(Arrays.asList(new String[]{"telecome"}))
            .build();

        ticketingService.ticketing(t);

        // 행동 검증
        verify(performanceService, times(1)).isEnableReserve(any());
        verify(reservationRepository, times(1)).save(any());
    }
}
