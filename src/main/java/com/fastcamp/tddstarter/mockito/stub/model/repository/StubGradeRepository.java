package com.fastcamp.tddstarter.mockito.stub.model.repository;

import java.util.HashMap;
import java.util.Map;

public class StubGradeRepository  { // implements GradeRepository {

    // 필요한 부분을 Override
    public Map<String, Integer> findByName(String name) {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("OOP", 8);
        result.put("FP", 6);
        result.put("DB", 10);
        return result;
    }

}
