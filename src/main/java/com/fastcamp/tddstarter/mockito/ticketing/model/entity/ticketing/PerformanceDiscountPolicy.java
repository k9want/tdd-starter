package com.fastcamp.tddstarter.mockito.ticketing.model.entity.ticketing;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "performance_discount_policy_info")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceDiscountPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "BINARY(16)", nullable = false, name = "performance_id")
    private UUID performanceId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = true)
    private BigDecimal rate;

    @Column(nullable = true, name = "discountFee")
    private int discountFee;

    @Column(nullable = false, name = "started_at")
    private Date startedAt;

    @Column(nullable = false, name = "ended_at")
    private Date endedAt;
}