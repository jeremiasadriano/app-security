package com.security.app_security.models.enums;

import lombok.Getter;

@Getter
public enum Roles {
    USER("user"), MANAGER("manager"), ADMIN("admin");
    private final String value;

    Roles(String value) {
        this.value = value;
    }
}
