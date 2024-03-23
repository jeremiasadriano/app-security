package com.security.app_security.models.dto;

import jakarta.validation.constraints.NotEmpty;

public record PersonRegister(@NotEmpty String name, @NotEmpty String email, @NotEmpty String password) {
}
