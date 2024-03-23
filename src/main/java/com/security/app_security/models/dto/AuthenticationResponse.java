package com.security.app_security.models.dto;

public record AuthenticationResponse(String token, PersonResponse response) {
}
