package com.fastcamp.tddstarter.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fastcamp.tddstarter.mockito.stub.model.Student;
import com.fastcamp.tddstarter.mockito.stub.model.repository.StubGradeRepository;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class StubGradleCalculateTests {

    private final StubGradeRepository stubGradeRepository;

    public StubGradleCalculateTests() {
        this.stubGradeRepository = new StubGradeRepository();
    }

    private Map<String, Integer> grades(Student s) {
        return stubGradeRepository.findByName(s.getName());
    }

    @Test
    void averageGradesTests() {
        Student s = new Student("sangkwon", 0, new HashMap<>(), 'M', "01012341234");
        Map<String, Integer> result = grades(s);
        int total = 0;
        int expected = 8;
        for (String grade : result.keySet()) {
            total += result.get(grade);
        }
        assertEquals(expected, total/result.size());

    }

}
