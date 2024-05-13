package com.fastcamp.tddstarter.mockito.ticketing.service;

import com.fastcamp.tddstarter.mockito.ticketing.model.dto.PerformanceInfo;
import com.fastcamp.tddstarter.mockito.ticketing.repository.PerformanceRepository;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PerformanceService {
    private final PerformanceRepository performanceRepository;

    public List<PerformanceInfo> getAllPerformanceInfo() {
        List<PerformanceInfo> reservablePerformanceInfos = performanceRepository.findByIsReserve("enable")
            .stream()
            .map(PerformanceInfo::of)
            .toList();
        if (reservablePerformanceInfos.isEmpty()) {
            return setReadyToPerformanceInfo();
        }
        return reservablePerformanceInfos;
    }

    public String isEnableReserve(UUID performanceId){
        System.out.println("Execute Production Code");
        return performanceRepository.findById(performanceId)
            .orElseThrow()
            .getIsReserve();
    }

    private List<PerformanceInfo> setReadyToPerformanceInfo(){
        PerformanceInfo readyToPerformance = PerformanceInfo.builder()
            .performanceId(UUID.fromString("0000-0000-0000-0000"))
            .performanceName("공연 준비중")
            .performanceType("none")
            .isReserve("disable")
            .build();
        return Arrays.asList(new PerformanceInfo[]{readyToPerformance});
    }

    public String getTicketName() {
        return "TicketName";
    }

}