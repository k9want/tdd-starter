package com.fastcamp.tddstarter.mockito.ticketing.model.dto;

import com.fastcamp.tddstarter.mockito.ticketing.model.entity.ticketing.PerformanceDiscountPolicy;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceDiscountPolicyInfo {
    private String policyName;
    private String policyType;
    private BigDecimal rate;
    private int discountFee;
    private Date startedDate;
    private Date endedDate;

    public static PerformanceDiscountPolicyInfo of(PerformanceDiscountPolicy entity) {
        return PerformanceDiscountPolicyInfo.builder()
            .policyName(entity.getName())
            .policyType(entity.getType())
            .rate(entity.getRate())
            .discountFee(entity.getDiscountFee())
            .startedDate(entity.getStartedAt())
            .endedDate(entity.getEndedAt())
            .build();
    }

    public static List<PerformanceDiscountPolicyInfo> getAllDiscountPolicies(List<PerformanceDiscountPolicy> entities){
        return entities.stream().map(PerformanceDiscountPolicyInfo::of).toList();

    }

}