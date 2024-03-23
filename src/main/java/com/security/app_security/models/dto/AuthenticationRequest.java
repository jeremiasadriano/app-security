package com.security.app_security.models.dto;

import jakarta.validation.constraints.NotEmpty;

public record AuthenticationRequest(@NotEmpty String username, @NotEmpty String password) {
}
