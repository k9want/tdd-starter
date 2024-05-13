package com.fastcamp.tddstarter.mockito.ticketing.repository;

import com.fastcamp.tddstarter.mockito.ticketing.model.entity.ticketing.Performance;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, UUID> {
    List<Performance> findByIsReserve(String isReserve);
    Performance findByName(String name);
}
