package com.fastcamp.tddstarter.mockito.stub.model;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private int averageGrade;
    private Map<String, Integer> grades;
    private char sex;
    private String phoneNumber;
}
