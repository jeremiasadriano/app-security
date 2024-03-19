package com.security.app_security.models;

import lombok.Getter;

@Getter
public enum Roles {
    USER(1), ADMIN(2), MANAGER(3);
    private final int value;

    Roles(int value) {
        this.value = value;
    }
}
