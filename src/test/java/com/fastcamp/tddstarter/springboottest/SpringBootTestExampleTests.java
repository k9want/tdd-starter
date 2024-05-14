package com.fastcamp.tddstarter.springboottest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fastcamp.tddstarter.mockito.ticketing.model.dto.Ticket;
import com.fastcamp.tddstarter.mockito.ticketing.model.entity.ticketing.Performance;
import com.fastcamp.tddstarter.mockito.ticketing.repository.PerformanceRepository;
import com.fastcamp.tddstarter.mockito.ticketing.service.TicketingService;
import jakarta.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.ANY, connection = EmbeddedDatabaseConnection.H2)
public class SpringBootTestExampleTests {

    @Autowired
    private TicketingService ticketingService;
    @Autowired
    private PerformanceRepository performanceRepository;

    @TestFactory
    @Transactional
    Stream<DynamicTest> refactorTest() {
        return Stream.of(DynamicTest.dynamicTest("공연 정보 저장", () -> {
            //given
            String name = "스프링부트 테스트 익숙해지기";
            Performance p = Performance.builder()
                .name(name)
                .type(0)
                .isReserve("enable")
                .round(1)
                .start_date(Date.valueOf(LocalDate.now()))
                .price(1000000000)
                .policies(new ArrayList<>())
                .build();
            //when
            performanceRepository.save(p);
            //then
            Performance insertedTestPerformance = performanceRepository.findByName(name);
            assertNotNull(insertedTestPerformance);
            assertEquals(p.getName(), insertedTestPerformance.getName());
            assertEquals(p.getStart_date(), insertedTestPerformance.getStart_date());
        }), DynamicTest.dynamicTest("공연 예약", () -> {
            //given
            String name = "스프링부트 테스트 익숙해지기";
            Performance insertedTestPerformance = performanceRepository.findByName(name);

            Ticket t = Ticket.builder()
                .performanceId(insertedTestPerformance.getId())
                .performanceName(insertedTestPerformance.getName())
                .reservationName("이상권")
                .reservationPhoneNumber("010-1234-5678")
                .reservationStatus("reserve")
                .round(1)
                .line('A')
                .seat(1)
                .appliedPolicies(new ArrayList<>())
                .build();
            //when
            Ticket reservedTicket = ticketingService.ticketing(t);
            //then
            assertEquals(t, reservedTicket);
        }));
    }


    @Test
    @Transactional
    void ticketingRserveIntegrationTest() {
        //given
        String name = "스프링부트 테스트 익숙해지기";
        Performance p = Performance.builder()
            .name(name)
            .type(0)
            .isReserve("enable")
            .round(1)
            .start_date(Date.valueOf(LocalDate.now()))
            .price(1000000000)
            .policies(new ArrayList<>())
            .build();
        //when
        performanceRepository.save(p);
        //then
        Performance insertedTestPerformance = performanceRepository.findByName(name);
        assertNotNull(insertedTestPerformance);
        assertEquals(p.getName(), insertedTestPerformance.getName());
        assertEquals(p.getStart_date(), insertedTestPerformance.getStart_date());

        //given
        Ticket t = Ticket.builder()
            .performanceId(insertedTestPerformance.getId())
            .performanceName(insertedTestPerformance.getName())
            .reservationName("이상권")
            .reservationPhoneNumber("010-1234-5678")
            .reservationStatus("reserve")
            .round(1)
            .line('A')
            .seat(1)
            .appliedPolicies(new ArrayList<>())
            .build();
        //when
        Ticket reservedTicket = ticketingService.ticketing(t);
        //then
        assertEquals(t, reservedTicket);
    }
}
