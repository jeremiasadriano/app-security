package com.security.app_security.models.dto;

import jakarta.validation.constraints.NotEmpty;

public record AuthRequest(@NotEmpty String email, @NotEmpty String password) {
}
