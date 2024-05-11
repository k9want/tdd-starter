package com.fastcamp.tddstarter.password;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {

    // 암호 검사기 규칙
    // - 길이가 8글자 이상
    // - 0부터 9 사이의 숫자를 포함
    // - 대문자 포함


    // 암호 검사기 규칙 조합의 경우의 수
    /*
    * STRONG
    * 모든 항목을 충족하는 경우 (1)
    *
    * NORMAL
    * 길이가 8글자 미만이고 모든 항목을 충족하는 경우 (2)
    * 숫자는 없고 나머지 항목은 충족하는 경우 (3)
    * 대문자가 없고 나머지 항목은 충족하는 경우 (4)
    *
    *
    * WEAK
    * 길이가 8글자 이상이고 나머지 항목은 충족하지 않는 경우 (5)
    * 숫자는 있고 나머지 항목은 충족하지 않는 경우
    * 대문자가 있고 나머지 항목은 충족하지 않는 경우
    *
    * ZERO
    * 모든 항목을 충족하지 않는 경우
    * */
    @Test
    void 모든_항목을_충족하는_경우() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12ABC!@"); // 기대: STRONG
        Assertions.assertEquals(PasswordStrength.STRONG, result);
    }

    @Test
    void 길이가_8글자_미만이고_모든항목을_충족하는_경우() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12AB!"); // 기대: STRONG
        Assertions.assertEquals(PasswordStrength.NORMAL, result);
    }

    @Test
    void 숫자는_없고_나머지_항목은_충족하는_경우() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("abcdABCD!"); // 기대: STRONG
        Assertions.assertEquals(PasswordStrength.NORMAL, result);
    }

    @Test
    void 대문자가_없고_나머지_항목은_충족하는_경우() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("abcd1234!"); // 기대: STRONG
        Assertions.assertEquals(PasswordStrength.NORMAL, result);
    }

    @Test
    void 길이가_8글자_이상이고_나머지_항목은_충족하지_않는_경우() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("abcdefghi!"); // 기대: STRONG
        Assertions.assertEquals(PasswordStrength.WEAK, result);
    }

    @Test
    void 숫자는_있고_나머지_항목은_충족하지_않는_경우() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("1234567"); // 기대: STRONG
        Assertions.assertEquals(PasswordStrength.WEAK, result);
    }
}
