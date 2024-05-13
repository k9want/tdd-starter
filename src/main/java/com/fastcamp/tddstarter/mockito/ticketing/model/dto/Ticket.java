package com.fastcamp.tddstarter.mockito.ticketing.model.dto;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Ticket {

    private UUID performanceId;
    private String performanceName;
    private String reservationName;
    private String reservationPhoneNumber;
    private String reservationStatus; // 예약, 취소
    private int price;
    private int point;
    private long amount;
    private int round;
    private int gate;
    private char line;
    private Integer seat;
    private List<String> appliedPolicies;

}
