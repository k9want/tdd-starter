package com.fastcamp.tddstarter.junitpractice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AssertEqualsTest {

    @Test
    void assertEqualsExampleTest() {
        int actual = 1;
        int expected = 2;
        assertNotEquals(expected, actual);
    }

    @Test
    void toUpperCaseThrowNullPointerExceptionTrueTest() {
        assertThrows(NullPointerException.class, () -> this.toUpperCase(null));
    }

    @Test
    void toUpperCaseThrowNullPointerExceptionTest() {
        try {
            String name = toUpperCase(null);
            // 실행의 흐름을 테스트할 때 사용하는 메서드
            // : NPE를 날려 catch로 넘어가야하는데 안 날리고 해당 코드를 실행하면 해당 테스트를 실패했다고 알려줘!! 느낌으로 사용
            fail();
            assertEquals("SANGKWON", name);
        } catch (NullPointerException e) {

        }
    }

    private String toUpperCase(String name) throws NullPointerException {
        if (name == null) {
            throw new NullPointerException();
        }
        return name.toUpperCase();
    }

}
