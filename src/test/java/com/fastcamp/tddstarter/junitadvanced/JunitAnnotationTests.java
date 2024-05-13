package com.fastcamp.tddstarter.junitadvanced;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import com.fastcamp.tddstarter.junitadvanced.dto.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class JunitAnnotationTests {

    @TestFactory
    List<DynamicNode> testFactoryExampleTest() {
        int size = 10;
        // DB에서 데이터를 가져와서 결정하거나
        // 외부 API 값을 가져와서 사용할 때
        ArrayList<DynamicNode> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int finalI = i;
            result.add(dynamicTest("Test CaseName" + i,
                () -> System.out.println("Dynamic Test #" + finalI)));

        }
        return result;
    }

    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    void repeatedTestExample_1(RepetitionInfo info) {
        int currentValue = info.getCurrentRepetition();
        assertEquals(currentValue * 2, currentValue*2);
    }

    @RepeatedTest(value = 10)
    void repeatedTestExample_2(RepetitionInfo info) {
        int currentValue = info.getCurrentRepetition();
        System.out.println("RepetitionInfo = " + info.getCurrentRepetition() + "/" + info.getTotalRepetitions());
        assertEquals(currentValue * 2, currentValue*2);
    }

    @ParameterizedTest
    @CsvSource(value = {"1|2" ,"2|4", "3|6"}, delimiter = '|')
//    @CsvSource(value = {"1||2" ,"2||4", "3||6"}, delimiterString = "||")
    void csvParameterizedTestExample(int input, int expected) {
        assertEquals(expected, input * 2);
    }


    @ParameterizedTest
//    @ValueSource(strings = {" ", ""})
    @NullAndEmptySource
    void AfterParameterizedTestExample(String userName) {
        assertThatThrownBy(() -> new User(userName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("User의 이름이 Null이면 예외발생")
    void BeforeParameterizedTestExample_1() {
        assertThatThrownBy(() -> new User(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("User의 이름이 공백이면 예외발생")
    void BeforeParameterizedTestExample_2() {
        assertThatThrownBy(() -> new User(" "))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
