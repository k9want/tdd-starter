package com.fastcamp.tddstarter.password;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String password) {

        final String numberReg = ".*\\d.*";
        final String upperReg = ".*[A-Z].*";

        // 길이 8 미만인 경우
        if (password.length() < 8) {
            return PasswordStrength.NORMAL;
        }

        // 숫자만 없는 경우
        if (!password.matches(numberReg)) {
            return PasswordStrength.NORMAL;
        }

        // 대문자가 없는 경우
        if (!password.matches(upperReg)) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }

}
