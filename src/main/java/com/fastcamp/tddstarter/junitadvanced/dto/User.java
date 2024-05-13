package com.fastcamp.tddstarter.junitadvanced.dto;

import lombok.Getter;

@Getter
public class User {

    private final String name;

    public User(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateNotNull(name);
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() > 10) {
            throw new IllegalArgumentException("이름은 10자리 이하여야 합니다.");
        }
    }

    private void validateNotNull(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백이나 널이 될 수 없습니다.");
        }
    }
    
    
}
