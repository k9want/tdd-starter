package com.fastcamp.tddstarter.password;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String password) {

        final String numberReg = ".*\\d.*";
        final String upperReg = ".*[A-Z].*";

        int level = 3;

        // 길이 8 미만인 경우
        if (password.length() < 8) {
            level -= 1;
        }

        // 숫자만 없는 경우
        if (!password.matches(numberReg)) {
            level -= 1;
        }

        // 대문자가 없는 경우
        if (!password.matches(upperReg)) {
            level -= 1;
        }

        if (level == 3) {
            return PasswordStrength.STRONG;
        } else if (level == 2) {
            return PasswordStrength.NORMAL;
        } else if (level == 1) {
            return PasswordStrength.WEAK;
        } else {
            return PasswordStrength.NOTHING;
        }
    }

}
